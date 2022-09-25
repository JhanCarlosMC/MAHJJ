package com.example.demo.mappers;


import com.example.demo.dto.TransactionDto;
import com.example.demo.model.Transaction;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper {

    Transaction convertDtoToModel(TransactionDto dataDto);

    @InheritInverseConfiguration
    TransactionDto convertModelToDto(Transaction data);

    List<TransactionDto> convertListModelToListDto(List<Transaction> data);

}
