package com.nt.portal.security;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class LoginAuditingListener implements ApplicationListener {
	  public void onApplicationEvent(ApplicationEvent event) {
	    if (event instanceof AuthenticationSuccessEvent) {
	      AuthenticationSuccessEvent authEvent = (AuthenticationSuccessEvent) event;
	      Authentication authentication = authEvent.getAuthentication();
	      // audit code here 
	      System.out.println("********************AUTHENTICTAION PASS****************************"+authentication.getName());
	    }

	    if (event instanceof AbstractAuthenticationFailureEvent) {
	      AbstractAuthenticationFailureEvent authEvent = (AbstractAuthenticationFailureEvent) event;
	      Authentication authentication = authEvent.getAuthentication();
	      AuthenticationException authenticationException = authEvent.getException();
	      // audit code here
	      System.out.println("********************AUTHENTICTAION FUCSK");
	    }
	  }
	}
