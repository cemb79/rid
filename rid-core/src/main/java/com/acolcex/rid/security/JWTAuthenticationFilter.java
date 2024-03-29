package com.acolcex.rid.security;

import static com.acolcex.rid.security.SecurityConstants.EXPIRATION_TIME;
import static com.acolcex.rid.security.SecurityConstants.HEADER_STRING;
import static com.acolcex.rid.security.SecurityConstants.SECRET;
import static com.acolcex.rid.security.SecurityConstants.TOKEN_PREFIX;
import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.acolcex.rid.controller.util.ApiResponse;
import com.acolcex.rid.model.dto.ApplicationUser;
import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        try {
            ApplicationUser creds = new ObjectMapper().readValue(req.getInputStream(), ApplicationUser.class);
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    creds.getUsername(),
                    creds.getPassword(),
                    new ArrayList<>());
            Authentication auth = authenticationManager.authenticate(token);
            return auth;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

    	Date expirationDate = new Date(System.currentTimeMillis() + (EXPIRATION_TIME * 100));
    	User user = (User) auth.getPrincipal();
        String token = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(expirationDate)
                .sign(HMAC512(SECRET.getBytes()));
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
        res.addHeader("Content-Type", "application/json");
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> body = new HashMap<>();
        body.put("idToken", token);
        body.put("expirationTime", EXPIRATION_TIME);
        ApiResponse api = ApiResponse.successResponse(body);
        mapper.writeValue(res.getOutputStream(), api);
    }
}
