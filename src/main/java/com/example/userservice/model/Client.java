package com.example.userservice.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Client extends User {
	
	private Long cartId;
	
	private boolean isBlocked;

}
