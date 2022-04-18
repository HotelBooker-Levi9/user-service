package com.example.userservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Role {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

}
