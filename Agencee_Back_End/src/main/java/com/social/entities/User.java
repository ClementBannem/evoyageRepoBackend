package com.social.entities;

/*******************************************************************************
 * 2017, this is the user entity class ,
 * this class implements users details of the spring security framework
 *******************************************************************************/

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Description of User.
 * 
 * @author kamal berriga
 */
@Entity
@Table(name = "user")
@Scope("session")
public class User implements UserDetails {
	public static enum Role {
		USER		
	}

	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Description of the property username.
	 */
	@Column(unique = true)
	private String username;
	/**
	 * Description of the property email.
	 */
	@Column(unique = true)
	private String email;
	/**
	 * Description of the property password.
	 */
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	/**
	 * Description of the property role , to grant authority to the user .
	 */
	private String role;
	/**
	 * Description of the property full name.
	 */
	private String fullName;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "confirmation_token")
	private String confirmationToken;

	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
   private Set<Client> clients = new HashSet<>();

	
	public User() {

	}

	public User(String username, String email, String password, String role, String fullName, boolean enabled,
			String confirmationToken) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.fullName = fullName;
		this.enabled = enabled;
		this.confirmationToken = confirmationToken;
	}



	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", role="
				+ role + ", fullName=" + fullName + ", enabled=" + enabled + ", confirmationToken=" + confirmationToken
				+ "]";
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getId() {
		return id;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
