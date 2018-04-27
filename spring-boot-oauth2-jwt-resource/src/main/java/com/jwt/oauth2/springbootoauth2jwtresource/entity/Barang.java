package com.jwt.oauth2.springbootoauth2jwtresource.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@Entity
@Table(name = "barang")
public class Barang implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idbarang;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "unitprice", nullable = false)
    private int unitprice;

    @Column(name = "quantity", nullable = false)
    private int quantity;
}
