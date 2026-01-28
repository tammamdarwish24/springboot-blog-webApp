package net.TammamDarwish.springboot_blog_webApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.TammamDarwish.springboot_blog_webApp.dto.RegistrationDto;

@Controller
public class AuthController {

	
	// handler  method to handle user registreration request
	@GetMapping("/register")
	public String showRegistrationForm(Model model)
	{
		RegistrationDto registrationDto= new RegistrationDto();
		model.addAttribute("registrationDto", registrationDto);
		return "register";
		
	}
}
