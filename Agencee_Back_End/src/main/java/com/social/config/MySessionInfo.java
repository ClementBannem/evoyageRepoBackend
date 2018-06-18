package com.social.config;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.context.SecurityContextHolder;

import com.social.entities.User;
import com.social.services.UserService;

//@Configuration
//@Scope("session")
public class MySessionInfo {
	private User user;
	
	@Autowired
	private UserService userService;
	
	@Bean
	public User getCurrentUser() {
		if(user == null) {
			user = userService.findByEmail(((Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getName());
		}
		return user;
	}

}
