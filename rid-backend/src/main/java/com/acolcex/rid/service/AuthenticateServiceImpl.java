package com.acolcex.rid.service;

import java.util.Collections;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.acolcex.rid.model.User;
import com.acolcex.rid.model.dto.AuthenticateResponse;
import com.acolcex.rid.repository.UserRepository;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticateServiceImpl.class);
	
	private UserRepository userRepository;
	
	public AuthenticateServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public AuthenticateResponse authenticate(String username, String password) {
		Optional<User> response = userRepository.findByUsernameAndPassword(username, password);
		try {
			User user = response.get();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> response = userRepository.findById(username);
		User user = null;
		try {
			user = response.get();
		} catch (Exception e) {
			logger.warn("User not found. {}", e.getMessage());
			throw new UsernameNotFoundException(username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
	}

}
