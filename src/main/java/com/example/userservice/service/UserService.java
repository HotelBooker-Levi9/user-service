package com.example.userservice.service;

import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return user;
        }

    }

    public boolean isEmailRegistered(String email) {
        boolean isEmailRegistered = false;
        for (User user : userRepository.findAll()) {
            if (user.getEmail().equals(email))
                isEmailRegistered = true;
        }
        return isEmailRegistered;
    }

    public boolean isUsernameRegistered(String username) {
        boolean isUsernameRegistered = false;
        for (User user : userRepository.findAll()) {
            if (user.getUsername().equals(username))
                isUsernameRegistered = true;
        }
        return isUsernameRegistered;
    }
}
