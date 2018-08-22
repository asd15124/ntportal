package com.nt.portal.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for Authorization end-points
 * 
 * @author suhail.ahmad
 * @version 1.0
 *
 */
/* @CrossOrigin(origins = "*", maxAge = 3600) */
@RestController(value = "/auth")
public class AuthorizationController extends BaseController {

	@GetMapping(value = "/test", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String testEndpoint() {
		return "It's working fine";
	}
}
