package com.example.userservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.dto.ClientDTO;
import com.example.userservice.mapper.ClientAdapter;
import com.example.userservice.model.Client;
import com.example.userservice.service.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
		Optional<Client> optClient = clientService.getById(id);
		
		ClientDTO clientDTO = ClientAdapter.convertToDTO(optClient.get());
		
		return new ResponseEntity<ClientDTO>(clientDTO, HttpStatus.OK);
	}

	
}

