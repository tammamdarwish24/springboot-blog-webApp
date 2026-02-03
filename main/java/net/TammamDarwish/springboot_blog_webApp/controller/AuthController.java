package net.TammamDarwish.springboot_blog_webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import net.TammamDarwish.springboot_blog_webApp.dto.RegistrationDto;
import net.TammamDarwish.springboot_blog_webApp.entity.User;
import net.TammamDarwish.springboot_blog_webApp.service.UserService;

@Controller
public class AuthController {

	private UserService userService;
	@GetMapping("/login")
	public String loginPage()
	{
		return "login";
		
	}
	
	@Autowired
	public AuthController(UserService userService) {
		super();
		this.userService = userService;
	}

	// handler  method to handle user registreration request
	@GetMapping("/register")
	public String showRegistrationForm(Model model)
	{
		RegistrationDto registrationDto= new RegistrationDto();
		model.addAttribute("user", registrationDto);
		return "register";
		
	}
	
	@PostMapping("/register/save")
	public String register (@Valid@ModelAttribute("user")RegistrationDto user,BindingResult result,Model model)
	{
		User exstingUser = userService.findByEmail(user.getEmail());
		
		if (exstingUser!=null)
		{
			result.rejectValue("email", null,"there is already user with ");
		}
		
		if (result.hasErrors())
		{
			model.addAttribute("user", user);
			return "register";
		}
		
		userService.saveUser(user);
		return "redirect:/register?success";
	}
	
	
	
}
