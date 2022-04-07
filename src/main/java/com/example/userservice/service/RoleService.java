package com.example.userservice.service;

import com.example.userservice.model.Role;
import com.example.userservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role findByName(String name) { return roleRepository.findByName(name); }
}
