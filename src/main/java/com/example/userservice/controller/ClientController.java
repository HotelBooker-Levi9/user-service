package com.example.userservice.controller;

import java.util.List;
import java.util.Optional;

import com.example.userservice.dto.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/")
	public ResponseEntity<List<ClientDTO>> getAllClients() {
		List<Client> clients = clientService.getAll();

		List<ClientDTO> clientDTOs = ClientAdapter.convertListToDTO(clients);

		return new ResponseEntity<List<ClientDTO>>(clientDTOs, HttpStatus.OK);
	}

	@GetMapping("clientEmailAndName/{cartId}")
	public ResponseEntity<?> getClientEmailAndName(@PathVariable Long cartId) {
		return clientService.getClientEmailAndName(cartId);
	}

	@PutMapping("block/{id}")
	public ResponseEntity<?> blockClient(@PathVariable Long id) {
		return clientService.block(id);
	}
}

