package com.orojasb.mapdtotest.services.impl;

import com.orojasb.mapdtotest.dtos.UserInformationDto;
import com.orojasb.mapdtotest.entities.User;
import com.orojasb.mapdtotest.mappers.UserMapper;
import com.orojasb.mapdtotest.projections.UserInformationProjection;
import com.orojasb.mapdtotest.repos.UserRepository;
import com.orojasb.mapdtotest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceimpl  implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> findAllDto() {
        return userRepo.findAll();
    }

    @Override
    public List<UserInformationProjection> findAllDtoProjection() {
        return null;
    }
}
