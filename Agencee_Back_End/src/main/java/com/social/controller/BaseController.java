package com.social.controller;

import org.springframework.security.core.context.SecurityContextHolder;

import com.social.entities.User;

public abstract class BaseController {
	
	protected User getCurrentUser() {
        return (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
