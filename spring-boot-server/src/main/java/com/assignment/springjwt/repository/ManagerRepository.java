package com.assignment.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.springjwt.models.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
	
	Optional<Manager> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);


}

