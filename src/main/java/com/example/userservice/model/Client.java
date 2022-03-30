package com.example.userservice.model;

import javax.persistence.Entity;

@Entity
public class Client extends User {
	
	private Long cartId;
	
	private boolean isBlocked;

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	
	
}
