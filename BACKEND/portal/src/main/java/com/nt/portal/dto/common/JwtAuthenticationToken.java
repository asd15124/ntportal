package com.nt.portal.dto.common;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Class for holding jwt authentication token
 * 
 * @author suhail.ahmad
 * @version 1.0
 *
 */
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 9166445422597291677L;
	private String token;

	public JwtAuthenticationToken(String token) {
		super(null, null);
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return null;
	}
}
