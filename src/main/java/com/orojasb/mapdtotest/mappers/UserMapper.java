package com.orojasb.mapdtotest.mappers;

import com.orojasb.mapdtotest.dtos.UserInformationDto;
import com.orojasb.mapdtotest.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mappings({
            @Mapping(source = "state.name", target = "stateName"),
    })
    UserInformationDto mapUserToUserInformationDto(User user);

}
