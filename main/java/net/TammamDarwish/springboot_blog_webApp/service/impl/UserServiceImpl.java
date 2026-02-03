package net.TammamDarwish.springboot_blog_webApp.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import net.TammamDarwish.springboot_blog_webApp.dto.RegistrationDto;
import net.TammamDarwish.springboot_blog_webApp.entity.Role;
import net.TammamDarwish.springboot_blog_webApp.entity.User;
import net.TammamDarwish.springboot_blog_webApp.repository.RoleRepository;
import net.TammamDarwish.springboot_blog_webApp.repository.UserRepository;
import net.TammamDarwish.springboot_blog_webApp.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
   @Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}


	@Override
	public void saveUser(RegistrationDto registrationDto) {
		
		User user = new User();
		user.setName(registrationDto.getFirstName()+" "+registrationDto.getLastName());
		user.setEmail(registrationDto.getEmail());
		//use spring security to encrypt password
		user.setPassword(registrationDto.getPassword());
		Role role = roleRepository.findByName("ROLE_GUEST");
		user.setRoles(Arrays.asList(role));
		userRepository.save(user);
		
	}


	@Override
	public User findByEmail(String email) {
		User user = userRepository.findByEmail(email);
		return user;
	} 


}
