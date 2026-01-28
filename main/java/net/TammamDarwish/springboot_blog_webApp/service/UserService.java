package net.TammamDarwish.springboot_blog_webApp.service;

import net.TammamDarwish.springboot_blog_webApp.dto.RegistrationDto;

public interface UserService {

	void saveUser(RegistrationDto registrationDto);
}
