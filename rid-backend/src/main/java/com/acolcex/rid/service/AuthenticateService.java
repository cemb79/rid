package com.acolcex.rid.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.acolcex.rid.model.dto.AuthenticateResponse;

public interface AuthenticateService extends UserDetailsService {

	AuthenticateResponse authenticate(String username, String password);
}
