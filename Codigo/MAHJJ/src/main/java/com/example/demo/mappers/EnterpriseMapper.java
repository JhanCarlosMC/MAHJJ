package com.example.demo.mappers;


import com.example.demo.dto.EnterpriseDto;
import com.example.demo.model.Enterprise;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnterpriseMapper {
    
    Enterprise convertDtoToModel(EnterpriseDto dataDto);

    @InheritInverseConfiguration
    EnterpriseDto convertModelToDto(Enterprise data);

    List<EnterpriseDto> convertListModelToListDto(List<Enterprise> data);

}
