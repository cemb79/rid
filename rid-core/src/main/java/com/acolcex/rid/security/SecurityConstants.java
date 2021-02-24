package com.acolcex.rid.security;

import com.acolcex.rid.controller.WebPaths;

public final class SecurityConstants {

	public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000; // 1 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = WebPaths.LOGIN;
    
	private SecurityConstants() {
		super();
	}
}
