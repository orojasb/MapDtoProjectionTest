package com.orojasb.mapdtotest.projections;

import lombok.Data;

@Data
public class UserInformationProjection {
    private int id;
    private String username;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String stateName;
    private String principalProfileName;
}
