package com.qd.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.qd.model.RegisterUser;

public class CustomUserDetails implements UserDetails {
	
	private RegisterUser register;
	
	
	public CustomUserDetails(RegisterUser register) {
		super();
		this.register = register;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return null;
	}

	@Override
	public String getPassword() {
		
		return register.getPassword();
	}

	@Override
	public String getUsername() {
		
		return register.getEmail();
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

}
