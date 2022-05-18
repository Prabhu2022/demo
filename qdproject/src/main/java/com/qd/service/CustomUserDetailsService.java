package com.qd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.qd.dao.RegisterDao;
import com.qd.model.RegisterUser;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private RegisterDao regdao;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		RegisterUser register =regdao.findByEmail(email);
		if(register == null)
		{
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(register);
	}

}
