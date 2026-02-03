package net.TammamDarwish.springboot_blog_webApp.service;

import net.TammamDarwish.springboot_blog_webApp.dto.RegistrationDto;
import net.TammamDarwish.springboot_blog_webApp.entity.User;

public interface UserService {

	void saveUser(RegistrationDto registrationDto);

	User findByEmail(String email);
}
