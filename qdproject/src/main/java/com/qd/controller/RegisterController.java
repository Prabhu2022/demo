package com.qd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qd.dao.RegisterDao;
import com.qd.model.RegisterUser;

@Controller
public class RegisterController 
{
	@Autowired
	private RegisterDao regdao;
	
	@RequestMapping("")
	public String viewHomePage()
	{
		return "index";
	}

	@RequestMapping("/register")
	public String showSignUpForm(Model model)
	{
		model.addAttribute("register", new RegisterUser());
		
		return "register";
		
	}
	@PostMapping("/processRegister")
	@ResponseBody
	public String processRegister(RegisterUser register)
	{
		RegisterUser existing = regdao.findByEmail(register.getEmail());
		
		if (existing != null) {
           return  "There is already an account registered with that email";
        }
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(register.getPassword());
	    register.setPassword(encodedPassword);
		regdao.save(register);
		return "registerSuccess";
		
	}
	@GetMapping("/list_users")
	public String viewUserList(Model model)
	{
		List <RegisterUser> listUsers = regdao.findAll();
		model.addAttribute("listUsers",listUsers);
		return "users";
		
	}
}
