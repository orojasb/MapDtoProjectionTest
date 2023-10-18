package com.orojasb.mapdtotest.controllers;

import com.orojasb.mapdtotest.dtos.UserInformationDto;
import com.orojasb.mapdtotest.mappers.UserMapper;
import com.orojasb.mapdtotest.projections.UserInformationProjection;
import com.orojasb.mapdtotest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<UserInformationDto> getUsersDto(){
        return userService.findAllDto().stream().map(user -> userMapper.mapUserToUserInformationDto(user))
                .collect(Collectors.toList());
    }


    @GetMapping("/projection")
    public List<UserInformationProjection> getUsersDtoprojection(){
        return userService.findAllDtoProjection();
    }
}
