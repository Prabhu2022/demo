package com.qd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


public class UserContoller {

	@RequestMapping("index")
	public String register()
	{
		return "index";
	}
	
}
