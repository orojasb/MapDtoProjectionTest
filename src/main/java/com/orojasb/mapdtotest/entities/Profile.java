package com.orojasb.mapdtotest.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profile")
@Data
public class Profile {

    @Id
    @Column(name = "code", nullable = false)
    private String code;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name = "profile_rol",
            joinColumns = @JoinColumn(name = "profile"),
            inverseJoinColumns = @JoinColumn(name = "rol"))
    private List<Rol> roles;

    @Column(name = "name")
    private String name;
}
