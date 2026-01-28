package net.TammamDarwish.springboot_blog_webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.TammamDarwish.springboot_blog_webApp.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

	
	User findByEmail(String email);
}
