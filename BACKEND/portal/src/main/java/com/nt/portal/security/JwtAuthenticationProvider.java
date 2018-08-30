package com.nt.portal.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.nt.portal.converter.RoleConverter;
import com.nt.portal.dto.RoleDto;
import com.nt.portal.dto.UserDto;
import com.nt.portal.services.impl.UserServiceImpl;

/**
 * Class for Authentication provider for JWT
 * 
 * @author suhail.ahmad
 * @version 1.0
 *
 */
@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private RoleConverter roleConverter;

	@Override
	public boolean supports(Class<?> authentication) {
		return (UserDto.class.isAssignableFrom(authentication));
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub

	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		UserDto jwtAuthenticationToken = (UserDto) authentication;
		String token = jwtAuthenticationToken.getToken();

		String userName = jwtTokenUtil.getUsernameFromToken(token);

		if (userName == null) {
			throw new RuntimeException("JWT Token is incorrect");
		}

		UserDto userDetails = userService.loadUserByUsername(userName);

		if (null == userDetails) {
			throw new RuntimeException("JWT Token is incorrect");
		}

		Set<RoleDto> roles = userDetails.getRoles();
		userDetails.setRoles(roles);
		userDetails.setAuthorities(new ArrayList<RoleDto>(roles));

		List<GrantedAuthority> grantedAuthorities = (List<GrantedAuthority>) userDetails.getAuthorities();

		return new UserDto(userDetails.getUserName(), userDetails.getId(), token, userDetails.getPassword(),
				grantedAuthorities);
	}

}
