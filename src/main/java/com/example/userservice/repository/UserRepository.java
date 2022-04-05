package com.example.userservice.repository;

import com.example.userservice.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
