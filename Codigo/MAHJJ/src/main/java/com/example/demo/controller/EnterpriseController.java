package com.example.demo.controller;

import com.example.demo.dto.MessageResponseDto;
import com.example.demo.dto.EnterpriseDto;
import com.example.demo.mappers.EnterpriseMapper;
import com.example.demo.model.Enterprise;
import com.example.demo.repository.EnterpriseRepository;
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
public class EnterpriseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private EnterpriseRepository repository;
    
    @Autowired
    private final EnterpriseMapper mapper;

    public EnterpriseController() {
        mapper = Mappers.getMapper(EnterpriseMapper.class);
    }

    @GetMapping("/enterprises")
    public List<EnterpriseDto> getEnterpriseAll(@RequestParam Map<String, String> dataRequest) {
        logger.info("info - { GET } /enterprises");
        List<EnterpriseDto> dataDto = new ArrayList<>();
        try {         
            List<Enterprise> dataModel = repository.findAll();
            dataDto = mapper.convertListModelToListDto(dataModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataDto;
    }

    @GetMapping("/enterprises/{id}")
    public EnterpriseDto getEnterprise( @PathVariable Long id, @RequestParam Map<String, String> dataRequest) {
        logger.info("info - { GET } /enterprises/" + id);
        EnterpriseDto dataDto = new EnterpriseDto();
        try {
            Optional<Enterprise> dataModel = repository.findById(id);
            dataDto = mapper.convertModelToDto(dataModel.get());   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataDto;
    }

    @PostMapping("/enterprises")
    public EnterpriseDto createEnterprise( @RequestBody EnterpriseDto dataDto, @RequestParam Map<String, String> dataRequest, HttpServletResponse response) {
        logger.info("info - { POST } /enterprises");
        logger.info("info - { POST }", dataDto.toString());
        Enterprise dataModel = new Enterprise();
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
            logger.debug("debug - { POST } /enterprises " + e.getMessage());
        }
        return dataDto;
    }

    @PutMapping("/enterprises/{id}")
    public MessageResponseDto updateEnterprise( @PathVariable Long id, @RequestBody EnterpriseDto dataDto, @RequestParam Map<String, String> dataRequest, HttpServletResponse response) {
        logger.info("info - { PUT } /enterprises/" + id);
        logger.info("info - { PUT }", dataDto.toString());
        MessageResponseDto messageResponseDto = new MessageResponseDto();
        Enterprise dataModel = new Enterprise();
        try {
            Optional<Enterprise> optionalModel = repository.findById(id);
            if (optionalModel.isPresent()) {
                dataModel = optionalModel.get();
                Enterprise dataModelTemp = mapper.convertDtoToModel(dataDto);
                // Setters
                dataModel.setId(id);
                dataModel.setName(dataModelTemp.getName());
                dataModel.setDocument(dataModelTemp.getDocument());
                dataModel.setPhone(dataModelTemp.getPhone());    
                dataModel.setAddress(dataModelTemp.getAddress());                
                repository.saveAndFlush(dataModel);
                response.setStatus(HttpServletResponse.SC_CREATED);
                messageResponseDto.setMessage(Parameters.SUCCESS);
            } else {
                messageResponseDto.setMessage(Parameters.FAIL);
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("info - { PUT } /enterprises/" + id + "  " + e.getMessage());
        }
        return messageResponseDto;
    }

    @DeleteMapping("/enterprises/{id}")
    public MessageResponseDto deleteEnterprise( @PathVariable Long id, @RequestParam Map<String, String> dataRequest, HttpServletResponse response) {
        logger.info("info - { DELETE } /enterprises/" + id);
        MessageResponseDto messageResponseDto = new MessageResponseDto();
        Enterprise dataModel = new Enterprise();
        try {
            Optional<Enterprise> optionalModel = repository.findById(id);
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
            logger.info("info - { DELETE } /enterprises/" + id + "  " + e.getMessage());
        }
        return messageResponseDto;
    }
}
