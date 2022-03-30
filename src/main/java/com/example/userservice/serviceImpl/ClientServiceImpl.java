package com.example.userservice.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	

}
