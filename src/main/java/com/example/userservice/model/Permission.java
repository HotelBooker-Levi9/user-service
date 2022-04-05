package com.example.userservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;



}
