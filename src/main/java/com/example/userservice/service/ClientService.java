package com.example.userservice.service;

import java.util.List;
import java.util.Optional;

import com.example.userservice.model.Client;
import org.springframework.http.ResponseEntity;

public interface ClientService {
	
	Optional<Client> getById(Long id);
    List<Client> getAll();

    ResponseEntity<?> getClientEmailAndName(Long cartId);

    ResponseEntity<?> block(Long id);
}
