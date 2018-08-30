package com.nt.portal.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.stereotype.Component;

import com.nt.portal.dto.UserDto;
import com.nt.portal.dto.common.Constants;

/**
 * Class for JWT Authentication Filter
 * 
 * @author suhail.ahmad
 * @version 1.0
 *
 */
@Component
public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	@Override
	@Autowired
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		super.setAuthenticationManager(authenticationManager);
	}

	public JwtAuthenticationFilter() {
		super("/rest/**");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		String header = request.getHeader(Constants.AUTHORIZATION_HEADER);

		if (header == null || !header.startsWith(Constants.TOKEN_PREFIX)) {
			throw new RuntimeException("JWT Token is missing");
		}

		String authenticationToken = header.substring(6);

		UserDto userDetails = new UserDto(authenticationToken);

		return getAuthenticationManager().authenticate(userDetails);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		SecurityContextHolder.getContext().setAuthentication(authResult);
		chain.doFilter(request, response);
	}

}
