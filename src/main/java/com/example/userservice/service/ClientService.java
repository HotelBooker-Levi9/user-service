package com.example.userservice.service;

import java.util.List;
import java.util.Optional;

import com.example.userservice.dto.ClientDTO;
import com.example.userservice.dto.EmailDTO;
import com.example.userservice.mapper.ClientAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.userservice.model.Client;
import com.example.userservice.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
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

	public ResponseEntity<?> registerClient(ClientDTO clientDto) {
		Client client = ClientAdapter.convertToClient(clientDto);
		client.setPassword(passwordEncoder.encode(client.getPassword()));

		try {
			saveNewClient(client);
		}
		catch (DataIntegrityViolationException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	private void saveNewClient(Client client) {
		client.setRole(roleService.findByName("ROLE_CLIENT"));
		clientRepository.save(client);
	}
}
