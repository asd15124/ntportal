package com.nt.portal.controller;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.portal.dto.UserDto;
import com.nt.portal.model.Role;
import com.nt.portal.model.User;
import com.nt.portal.security.JwtTokenUtil;
import com.nt.portal.services.UserService;

/**
 * Controller class for Authorization end-points
 * 
 * @author suhail.ahmad
 * @version 1.0
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
@RequestMapping({ "/auth" })
public class AuthorizationController extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtTokenUtil jwtUtil;

	@GetMapping(value = "/test")
	public String testEndpoint() {
		LOGGER.info("inside AuthorizationController for test endpoint");
		return "It's working fine";
	}

	@PostMapping(value = "/signUp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String signUp(@RequestBody UserDto user) {

		LOGGER.info("inside AuthorizationController for signUp endpoint");
		User userDetails = userService.save(user);
		return jwtUtil.createJWT(userDetails.getUserId().toString(), userDetails.getUserName(), "ADMIN", System.currentTimeMillis());

	}

	@PostMapping(value = "/signIn", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User signIn(@RequestBody UserDto userDto) throws Exception {

		LOGGER.info("inside AuthorizationController for signIn endpoint");
		User user = userService.findOne(userDto.getUserName());
		if (null != user) {
			if (StringUtils.equalsIgnoreCase(userDto.getPassword(), user.getPassword())) {
				return user;
			} else {
				/*
				 * throw new SecurityException("User Credentials are invalid");
				 */
				throw new Exception("User Credentials are invalid");
			}
		} else {
			throw new Exception("User not found with the given username");
		}

	}
}
