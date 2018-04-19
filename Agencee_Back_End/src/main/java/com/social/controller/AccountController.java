package com.social.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.dao.UserRepository;
import com.social.entities.User;
import com.social.services.EmailService;
import com.social.services.UserService;
import com.social.util.CustomErrorType;

/**
 * @author kamal berriga
 *
 */
@RestController
@RequestMapping("account")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class AccountController {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private EmailService emailService;

	public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository repository;

	// request method to create a new account by a guest

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User newUser, BindingResult bindingResult,
			HttpServletRequest request, @RequestParam Map<String, String> requestParams) {
		if (userService.find(newUser.getUsername()) != null) {
			logger.error("username Already exist " + newUser.getUsername());
			return new ResponseEntity(
					new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
					HttpStatus.CONFLICT);
		} else {
			newUser.setEnabled(false);
			newUser.setRole("AGENT");
			newUser.setConfirmationToken(UUID.randomUUID().toString());
			// newUser.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));

			String appUrl = request.getScheme() + "://" + request.getServerName();

			SimpleMailMessage registrationEmail = new SimpleMailMessage();
			registrationEmail.setTo(newUser.getEmail());
			registrationEmail.setSubject("Registration Confirmation");
			registrationEmail.setText("To confirm your e-mail address, please click the link below:\n" + appUrl
					+ "/confirm?token=" + newUser.getConfirmationToken());
			registrationEmail.setFrom("noreply@domain.com");

			emailService.sendEmail(registrationEmail);

			return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
		}
	}
	
	@RequestMapping(value = "/registerClient", method = RequestMethod.POST)
	public ResponseEntity<?> createUserClient(@RequestBody User newUser, BindingResult bindingResult,
			HttpServletRequest request, @RequestParam Map<String, String> requestParams) {
		if (userService.find(newUser.getUsername()) != null) {
			logger.error("username Already exist " + newUser.getUsername());
			return new ResponseEntity(
					new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
					HttpStatus.CONFLICT);
		} else {
			newUser.setEnabled(false);
			newUser.setRole("USER");
			newUser.setConfirmationToken(UUID.randomUUID().toString());
			// newUser.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));

			String appUrl = request.getScheme() + "://" + request.getServerName();

			SimpleMailMessage registrationEmail = new SimpleMailMessage();
			registrationEmail.setTo(newUser.getEmail());
			registrationEmail.setSubject("Registration Confirmation");
			registrationEmail.setText("To confirm your e-mail address, please click the link below:\n" + appUrl
					+ "/confirm?token=" + newUser.getConfirmationToken());
			registrationEmail.setFrom("noreply@domain.com");

			emailService.sendEmail(registrationEmail);

			return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
		}
	}
	
	// Process confirmation link
		/*@RequestMapping(value = "/confirmAccount", method = RequestMethod.GET)
		public ResponseEntity<?> confirmRegistration(@RequestParam("token") String token) {

			User user = userService.findByConfirmationToken(token);

			if (user == null) { // No token found in DB
				modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");
			} else { // Token found
				modelAndView.addObject("confirmationToken", user.getConfirmationToken());
			}

			modelAndView.setViewName("confirm");
			return modelAndView;
		}*/

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> getUser() {
		return (List<User>) repository.findAll();
	}

	// this is the login api/service

	@RequestMapping("/login")
	public Principal user(Principal principal) {
		logger.info("user logged " + principal);
		return principal;
	}

}
