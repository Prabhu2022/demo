package com.qd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qd.model.RegisterUser;


public interface RegisterDao extends JpaRepository <RegisterUser, String> {

	@Query (" SELECT u FROM RegisterUser WHERE u.email = ?1")
	public RegisterUser findByEmail(String email);
	
	//@Query("SELECT u FROM User u WHERE u.email = ?1")
   // public User findByEmail(String email);
}
