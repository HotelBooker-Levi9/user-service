package com.example.userservice.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;


@MappedSuperclass
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	private String name;
	
	private String surname;
	
	private String email;
	
	private String password;
	
	private String salt;
	
	private boolean isDeleted;
	
	@OneToOne(targetEntity = Role.class)
	private Role role;

	public User() {
		super();
	}

	public User(Long id, String username, String name, String surname, String email, String password, String salt,
			boolean isDeleted) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.salt = salt;
		this.isDeleted = isDeleted;
	}

}
