package com.example.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userservice.model.Client;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	Optional<Client> findById(Long id);

	Client findByCartId(Long cartId);

	@Transactional
	@Modifying
	@Query("UPDATE Client r SET r.isBlocked = true WHERE r.id = :id")
    void block(@Param("id") Long id);
}
