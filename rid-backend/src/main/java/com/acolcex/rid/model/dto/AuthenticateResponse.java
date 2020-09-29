package com.acolcex.rid.model.dto;

import java.io.Serializable;

public class AuthenticateResponse implements Serializable {
	
	private static final long serialVersionUID = -2047185125834377379L;

	private String token;
	private String userId;
	private String role;
	private boolean authenticated;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isAuthenticated() {
		return authenticated;
	}
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
	
	@Override
	public String toString() {
		return "AuthenticateResponse [token=" + token + ", userId=" + userId + ", role=" + role + "]";
	}
	
}
