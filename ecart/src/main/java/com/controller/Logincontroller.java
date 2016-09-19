package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Logincontroller 
{
	@RequestMapping(value="/")
	public String showHome()
	{
		return "home";
		
	}
	
	@RequestMapping("/login")
	public String showLogin()
	{
		return "login";
	}
	@RequestMapping("/signup")
	public String showSignUp()
	{
		return "signup";
	}
	@RequestMapping("/aboutus")
	public String showAboutUs()
	{
		return "aboutus";
	}
	@RequestMapping("/contactus")
	public String showContactUs(){
		return "contactus";
	}
}
