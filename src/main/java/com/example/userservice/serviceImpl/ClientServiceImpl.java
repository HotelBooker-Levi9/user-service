package com.example.userservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.example.userservice.dto.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.userservice.model.Client;
import com.example.userservice.repository.ClientRepository;
import com.example.userservice.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public Optional<Client> getById(Long id) {
		return clientRepository.findById(id);
	}

	@Override
	public List<Client> getAll() {
		return clientRepository.findAll();
	}

	@Override
	public ResponseEntity<?> getClientEmailAndName(Long cartId) {
		Client client = clientRepository.findByCartId(cartId);
		return new ResponseEntity<>(new EmailDTO(client.getEmail(), client.getName()), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> block(Long id) {
		clientRepository.block(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
