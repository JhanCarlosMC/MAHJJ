package com.example.demo.controller;

import com.example.demo.dto.MessageResponseDto;
import com.example.demo.dto.TransactionDto;
import com.example.demo.mappers.TransactionMapper;
import com.example.demo.model.Transaction;
import com.example.demo.repository.TransactionRepository;
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
public class TransactionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private TransactionRepository repository;
    
    @Autowired
    private final TransactionMapper mapper;

    public TransactionController() {
        mapper = Mappers.getMapper(TransactionMapper.class);
    }

    @GetMapping("/transactions")
    public List<TransactionDto> getTransactionAll(@RequestParam Map<String, String> dataRequest) {
        logger.info("info - { GET } /transactions");
        List<TransactionDto> dataDto = new ArrayList<>();
        try {         
            List<Transaction> dataModel = repository.findAll();
            dataDto = mapper.convertListModelToListDto(dataModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataDto;
    }

    @GetMapping("/transactions/{id}")
    public TransactionDto getTransaction( @PathVariable Long id, @RequestParam Map<String, String> dataRequest) {
        logger.info("info - { GET } /transactions/" + id);
        TransactionDto dataDto = new TransactionDto();
        try {
            Optional<Transaction> dataModel = repository.findById(id);
            dataDto = mapper.convertModelToDto(dataModel.get());   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataDto;
    }

    @PostMapping("/transactions")
    public TransactionDto createTransaction( @RequestBody TransactionDto dataDto, @RequestParam Map<String, String> dataRequest, HttpServletResponse response) {
        logger.info("info - { POST } /transactions");
        logger.info("info - { POST }", dataDto.toString());
        Transaction dataModel = new Transaction();
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
            logger.debug("debug - { POST } /transactions " + e.getMessage());
        }
        return dataDto;
    }

    @PutMapping("/transactions/{id}")
    public MessageResponseDto updateTransaction( @PathVariable Long id, @RequestBody TransactionDto dataDto, @RequestParam Map<String, String> dataRequest, HttpServletResponse response) {
        logger.info("info - { PUT } /transactions/" + id);
        logger.info("info - { PUT }", dataDto.toString());
        MessageResponseDto messageResponseDto = new MessageResponseDto();
        Transaction dataModel = new Transaction();
        try {
            Optional<Transaction> optionalModel = repository.findById(id);
            if (optionalModel.isPresent()) {
                dataModel = optionalModel.get();
                Transaction dataModelTemp = mapper.convertDtoToModel(dataDto);
                // Setters
                dataModel.setId(id);
                dataModel.setConcept(dataModelTemp.getConcept());
                dataModel.setAmount(dataModelTemp.getAmount());
                repository.saveAndFlush(dataModel);
                response.setStatus(HttpServletResponse.SC_CREATED);
                messageResponseDto.setMessage(Parameters.SUCCESS);
            } else {
                messageResponseDto.setMessage(Parameters.FAIL);
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("info - { PUT } /transactions/" + id + "  " + e.getMessage());
        }
        return messageResponseDto;
    }

    @DeleteMapping("/transactions/{id}")
    public MessageResponseDto deleteTransaction( @PathVariable Long id, @RequestParam Map<String, String> dataRequest, HttpServletResponse response) {
        logger.info("info - { DELETE } /transactions/" + id);
        MessageResponseDto messageResponseDto = new MessageResponseDto();
        Transaction dataModel = new Transaction();
        try {
            Optional<Transaction> optionalModel = repository.findById(id);
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
            logger.info("info - { DELETE } /transactions/" + id + "  " + e.getMessage());
        }
        return messageResponseDto;
    }
}
