package com.example.userservice.model;

import javax.persistence.Entity;

@Entity
public class Client extends User {
	
	private Long cartId;
	
	private boolean isBlocked;
	
	
}
