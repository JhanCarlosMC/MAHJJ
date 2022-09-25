package com.example.demo.controller;

import com.example.demo.dto.MessageResponseDto;
import com.example.demo.dto.UserDto;
import com.example.demo.mappers.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.HttpEndpointUtil;
import com.example.demo.utils.Parameters;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(HttpEndpointUtil.WEB_SERVER_BASE_API_URL)
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private UserRepository repository;
    
    @Autowired
    private final UserMapper mapper;

    public UserController() {
        mapper = Mappers.getMapper(UserMapper.class);
    }

    @GetMapping("/users")
    public List<UserDto> getUserAll(@RequestParam Map<String, String> dataRequest) {
        logger.info("info - { GET } /users");
        List<UserDto> dataDto = new ArrayList<>();
        try {         
            List<User> dataModel = repository.findAll();
            dataDto = mapper.convertListModelToListDto(dataModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataDto;
    }

    @GetMapping("/users/{id}")
    public UserDto getUser( @PathVariable Long id, @RequestParam Map<String, String> dataRequest) {
        logger.info("info - { GET } /users/" + id);
        UserDto dataDto = new UserDto();
        try {
            Optional<User> dataModel = repository.findById(id);
            dataDto = mapper.convertModelToDto(dataModel.get());   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataDto;
    }

    @PostMapping("/users")
    public UserDto createUser( @RequestBody UserDto dataDto, @RequestParam Map<String, String> dataRequest, HttpServletResponse response) {
        logger.info("info - { POST } /users");
        logger.info("info - { POST }", dataDto.toString());
        User dataModel = new User();
        try {
            if (dataDto.getId() == null) {
                dataModel = mapper.convertDtoToModel(dataDto);
                dataModel = repository.saveAndFlush(dataModel);
                dataDto = mapper.convertModelToDto(dataModel); 
            } else {
                response.setStatus(HttpServletResponse.SC_CREATED);
                dataDto = mapper.convertModelToDto(dataModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("debug - { POST } /users " + e.getMessage());
        }
        return dataDto;
    }

    @PutMapping("/users/{id}")
    public MessageResponseDto updateUser( @PathVariable Long id, @RequestBody UserDto dataDto, @RequestParam Map<String, String> dataRequest, HttpServletResponse response) {
        logger.info("info - { PUT } /users/" + id);
        logger.info("info - { PUT }", dataDto.toString());
        MessageResponseDto messageResponseDto = new MessageResponseDto();
        User dataModel = new User();
        try {
            Optional<User> optionalModel = repository.findById(id);
            if (optionalModel.isPresent()) {
                dataModel = optionalModel.get();
                User dataModelTemp = mapper.convertDtoToModel(dataDto);
                // Setters
                dataModel.setId(id);
                dataModel.setEmail(dataModelTemp.getEmail());
                dataModel.setName(dataModelTemp.getName());
                dataModel.setRol(dataModelTemp.getRol());                
                repository.saveAndFlush(dataModel);
                response.setStatus(HttpServletResponse.SC_CREATED);
                messageResponseDto.setMessage(Parameters.SUCCESS);
            } else {
                messageResponseDto.setMessage(Parameters.FAIL);
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("info - { PUT } /users/" + id + "  " + e.getMessage());
        }
        return messageResponseDto;
    }

    @DeleteMapping("/users/{id}")
    public MessageResponseDto deleteUser( @PathVariable Long id, @RequestParam Map<String, String> dataRequest, HttpServletResponse response) {
        logger.info("info - { DELETE } /users/" + id);
        MessageResponseDto messageResponseDto = new MessageResponseDto();
        User dataModel = new User();
        try {
            Optional<User> optionalModel = repository.findById(id);
            if (optionalModel.isPresent()) {
                dataModel = optionalModel.get();    
                repository.delete(dataModel);
                response.setStatus(HttpServletResponse.SC_CREATED);
                messageResponseDto.setMessage(Parameters.SUCCESS);
            } else {
                messageResponseDto.setMessage(Parameters.FAIL);
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("info - { DELETE } /users/" + id + "  " + e.getMessage());
        }
        return messageResponseDto;
    }
}
