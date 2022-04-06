package com.example.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

	private Long id;
	private String username;
	private String name;
	private String surname;
	private String email;
	private String password;
	private boolean isDeleted;
	private Long cartId;
	private boolean isBlocked;


}
