package com.nt.portal.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class for JWT Success Handler
 * 
 * @author suhail.ahmad
 * @version 1.0
 *
 */
@Component
public class JwtSuccessHandler implements AuthenticationSuccessHandler {
	public static final Logger LOGGER = LoggerFactory.getLogger(JwtSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Authentication authentication) throws IOException, ServletException {
		LOGGER.info("*************Successfully Authentication******************");
	}
}
