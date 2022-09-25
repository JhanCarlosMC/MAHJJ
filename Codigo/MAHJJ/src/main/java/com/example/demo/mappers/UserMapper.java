package com.example.demo.mappers;


import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = { TransactionMapper.class, ProfileMapper.class})
public interface UserMapper {

    User convertDtoToModel(UserDto dataDto);

    @InheritInverseConfiguration
    UserDto convertModelToDto(User data);

    List<UserDto> convertListModelToListDto(List<User> data);

}
