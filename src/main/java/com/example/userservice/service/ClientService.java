package com.example.userservice.service;

import java.util.Optional;

import com.example.userservice.model.Client;

public interface ClientService {
	
	Optional<Client> getById(Long id);
}
