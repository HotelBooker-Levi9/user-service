package com.example.userservice.mapper;

import com.example.userservice.dto.ClientDTO;
import com.example.userservice.model.Client;

public class ClientAdapter {
	
	//prebaci client u clientDTO
	static public ClientDTO convertToDTO(Client client) {
		
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setId(client.getId());
		clientDTO.setEmail(client.getEmail());
		clientDTO.setPassword(client.getPassword());
		clientDTO.setName(client.getName());
		clientDTO.setSurname(client.getSurname());
		clientDTO.setUsername(client.getUsername());
		clientDTO.setSalt(client.getSalt());
		clientDTO.setBlocked(client.isBlocked());
		clientDTO.setDeleted(client.isDeleted());
		clientDTO.setCartId(client.getCartId());
		
		return clientDTO;
		
	}
	
	static public Client convertToClient(ClientDTO dto) {
		
		Client client = new Client();
		client.setId(dto.getId());
		client.setBlocked(dto.isBlocked());
		client.setDeleted(dto.isDeleted());
		client.setCartId(dto.getCartId());
		client.setEmail(dto.getEmail());
		client.setName(dto.getName());
		client.setPassword(dto.getPassword());
		client.setSalt(dto.getSalt());
		client.setSurname(dto.getSurname());
		client.setUsername(dto.getUsername());
		
		return client;
		
	}
	
}
