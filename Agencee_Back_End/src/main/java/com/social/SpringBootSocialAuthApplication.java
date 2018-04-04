package com.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.social.dao.ClientRepository;
import com.social.entities.Client;
/**
 * 
 * @author kamal berriga
 *
 */
@SpringBootApplication
public class SpringBootSocialAuthApplication /*implements CommandLineRunner*/{
	@Autowired
	private ClientRepository cr;
	
	//test git
	//test git noel
	//test perm denied

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSocialAuthApplication.class, args);
	}	
}
