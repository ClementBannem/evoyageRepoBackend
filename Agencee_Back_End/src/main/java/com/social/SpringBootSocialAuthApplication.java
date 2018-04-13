package com.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.social.dao.ClientRepository;
/**
 * 
 * @author kamal berriga
 *
 */
@SpringBootApplication
@EnableAsync
public class SpringBootSocialAuthApplication {
	@Autowired
	private ClientRepository cr;
	
	//test
	//test 2
	//test 3

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSocialAuthApplication.class, args);
	}	
}
