package com.nagarro.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.nagarro.entity.User;

import org.springframework.security.core.userdetails.*;

/**
 * This class implements UserDetailsService interface , which is used to
 * retrieve the user’s authentication and authorization information.
 * @author saumyaawasthi
 * 
 *
 */

public class CustomerUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private User user;

	public CustomerUserDetails(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getEmailId());
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmailId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String userName() {
		return user.getFirstName();
	}
}