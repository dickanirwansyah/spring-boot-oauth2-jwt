package com.jwt.oauth2.springbootoauth2jwt.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@Table(name = "tabel_users")
public class Users implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idusers;

    @Column(name = "username", nullable = false)
    private String username;

    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "activated")
    private boolean activated;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tabel_users_roles", joinColumns =
    @JoinColumn(name = "idusers", referencedColumnName = "idusers"), inverseJoinColumns =
    @JoinColumn(name = "idroles", referencedColumnName = "idroles"))
    private List<Roles> rolesList = new ArrayList<>();
}
