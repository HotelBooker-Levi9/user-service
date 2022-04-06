package com.example.userservice.service;

import java.util.List;
import java.util.Optional;

import com.example.userservice.dto.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.userservice.model.Client;
import com.example.userservice.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public Optional<Client> getById(Long id) {
		return clientRepository.findById(id);
	}

	public List<Client> getAll() {
		return clientRepository.findAll();
	}

	public ResponseEntity<?> getClientEmailAndName(Long cartId) {
		Client client = clientRepository.findByCartId(cartId);
		return new ResponseEntity<>(new EmailDTO(client.getEmail(), client.getName()), HttpStatus.OK);
	}


}
