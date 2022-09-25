package com.example.demo.controller;

import com.example.demo.dto.MessageResponseDto;
import com.example.demo.dto.ProfileDto;
import com.example.demo.mappers.ProfileMapper;
import com.example.demo.model.Profile;
import com.example.demo.repository.ProfileRepository;
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
public class ProfileController {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private ProfileRepository repository;
    
    @Autowired
    private final ProfileMapper mapper;

    public ProfileController() {
        mapper = Mappers.getMapper(ProfileMapper.class);
    }

    @GetMapping("/profiles")
    public List<ProfileDto> getProfileAll(@RequestParam Map<String, String> dataRequest) {
        logger.info("info - { GET } /profiles");
        List<ProfileDto> dataDto = new ArrayList<>();
        try {         
            List<Profile> dataModel = repository.findAll();
            dataDto = mapper.convertListModelToListDto(dataModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataDto;
    }

    @GetMapping("/profiles/{id}")
    public ProfileDto getProfile( @PathVariable Long id, @RequestParam Map<String, String> dataRequest) {
        logger.info("info - { GET } /profiles/" + id);
        ProfileDto dataDto = new ProfileDto();
        try {
            Optional<Profile> dataModel = repository.findById(id);
            dataDto = mapper.convertModelToDto(dataModel.get());   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataDto;
    }

    @PostMapping("/profiles")
    public ProfileDto createProfile( @RequestBody ProfileDto dataDto, @RequestParam Map<String, String> dataRequest, HttpServletResponse response) {
        logger.info("info - { POST } /profiles");
        logger.info("info - { POST }", dataDto.toString());
        Profile dataModel = new Profile();
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
            logger.debug("debug - { POST } /profiles " + e.getMessage());
        }
        return dataDto;
    }

    @PutMapping("/profiles/{id}")
    public MessageResponseDto updateProfile( @PathVariable Long id, @RequestBody ProfileDto dataDto, @RequestParam Map<String, String> dataRequest, HttpServletResponse response) {
        logger.info("info - { PUT } /profiles/" + id);
        logger.info("info - { PUT }", dataDto.toString());
        MessageResponseDto messageResponseDto = new MessageResponseDto();
        Profile dataModel = new Profile();
        try {
            Optional<Profile> optionalModel = repository.findById(id);
            if (optionalModel.isPresent()) {
                dataModel = optionalModel.get();
                Profile dataModelTemp = mapper.convertDtoToModel(dataDto);
                // Setters
                dataModel.setId(id);
                dataModel.setImage(dataModelTemp.getImage());
                dataModel.setPhone(dataModelTemp.getPhone());
                repository.saveAndFlush(dataModel);
                response.setStatus(HttpServletResponse.SC_CREATED);
                messageResponseDto.setMessage(Parameters.SUCCESS);
            } else {
                messageResponseDto.setMessage(Parameters.FAIL);
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("info - { PUT } /profiles/" + id + "  " + e.getMessage());
        }
        return messageResponseDto;
    }

    @DeleteMapping("/profiles/{id}")
    public MessageResponseDto deleteProfile( @PathVariable Long id, @RequestParam Map<String, String> dataRequest, HttpServletResponse response) {
        logger.info("info - { DELETE } /profiles/" + id);
        MessageResponseDto messageResponseDto = new MessageResponseDto();
        Profile dataModel = new Profile();
        try {
            Optional<Profile> optionalModel = repository.findById(id);
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
            logger.info("info - { DELETE } /profiles/" + id + "  " + e.getMessage());
        }
        return messageResponseDto;
    }
}
