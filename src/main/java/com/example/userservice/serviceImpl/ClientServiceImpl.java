package com.example.userservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.example.userservice.dto.ClientDTO;
import com.example.userservice.dto.EmailDTO;
import com.example.userservice.mapper.ClientAdapter;
import com.example.userservice.model.Role;
import com.example.userservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.userservice.model.Client;
import com.example.userservice.repository.ClientRepository;
import com.example.userservice.service.ClientService;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientServiceImpl implements ClientService {

	public static final String GATEWAY_URL = "http://localhost:8765/";
	
	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private RoleRepository roleRepository;
	
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

	@Override
	public ResponseEntity<?> registerClient(ClientDTO clientDTO) {
		Client client = ClientAdapter.convertToClient(clientDTO);

		Role role = roleRepository.findByName("ROLE_CLIENT");
		if(role == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		client.setRole(role);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Long> cartId = restTemplate.getForEntity(GATEWAY_URL + "carts/createCart/" + client.getId(), Long.class);

		if(cartId.getBody() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		client.setCartId(cartId.getBody());
		clientRepository.save(client);
		return new ResponseEntity<>(client, HttpStatus.OK);
	}

}
