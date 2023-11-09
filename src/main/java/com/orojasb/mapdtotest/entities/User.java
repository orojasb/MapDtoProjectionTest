package com.orojasb.mapdtotest.entities;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(fetch=FetchType.LAZY,targetEntity=UserState.class)
    @JoinColumn(name="state",nullable=false)
    private UserState state;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name = "user_profile",
            joinColumns = @JoinColumn(name = "user"),
            inverseJoinColumns = @JoinColumn(name = "profile"))
    private List<Profile> profiles;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;
}

