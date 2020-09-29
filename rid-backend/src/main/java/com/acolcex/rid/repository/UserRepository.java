package com.acolcex.rid.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acolcex.rid.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> findByUsernameAndPassword(String username, String password);
	Optional<User> findByUsername(String username);
}
