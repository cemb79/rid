package com.acolcex.rid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acolcex.rid.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
