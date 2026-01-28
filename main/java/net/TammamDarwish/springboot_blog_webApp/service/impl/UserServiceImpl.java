package net.TammamDarwish.springboot_blog_webApp.service.impl;

import net.TammamDarwish.springboot_blog_webApp.dto.RegistrationDto;
import net.TammamDarwish.springboot_blog_webApp.entity.User;
import net.TammamDarwish.springboot_blog_webApp.repository.RoleRepository;
import net.TammamDarwish.springboot_blog_webApp.repository.UserRepository;
import net.TammamDarwish.springboot_blog_webApp.service.UserService;

public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}


	@Override
	public void saveUser(RegistrationDto registrationDto) {
		
		User user = new User();
		
	}

}
