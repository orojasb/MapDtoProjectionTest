package com.orojasb.mapdtotest.services;

import com.orojasb.mapdtotest.dtos.UserInformationDto;
import com.orojasb.mapdtotest.entities.User;
import com.orojasb.mapdtotest.projections.UserInformationProjection;

import java.util.List;

public interface UserService {

    List<User> findAllDto();
    List<UserInformationProjection> findAllDtoProjection();

}
