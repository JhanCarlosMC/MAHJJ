package com.example.demo.mappers;


import com.example.demo.dto.ProfileDto;
import com.example.demo.model.Profile;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfileMapper {

    Profile convertDtoToModel(ProfileDto dataDto);

    @InheritInverseConfiguration
    ProfileDto convertModelToDto(Profile data);

    List<ProfileDto> convertListModelToListDto(List<Profile> data);

}
