package com.example.userservice.controller;

import com.example.userservice.dto.ClientDTO;
import com.example.userservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/register")
    public ResponseEntity<?> registerClient(@RequestBody ClientDTO clientDto) {
        return clientService.registerClient(clientDto);
    }

    @GetMapping("/hello")
    public String hello(Principal principal) {
        return SecurityContextHolder.getContext().getAuthentication().toString();
    }
}
