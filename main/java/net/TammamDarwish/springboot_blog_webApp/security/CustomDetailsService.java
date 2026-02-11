package net.TammamDarwish.springboot_blog_webApp.security;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import net.TammamDarwish.springboot_blog_webApp.repository.UserRepository;
@Service
public class CustomDetailsService implements UserDetailsService {
	/*spring provides userdetails service interface and spring boot 
	 * creates instance of UserDetailsService to create in memory authentication object*/

	private UserRepository userRepository;
	@Autowired
	public CustomDetailsService(UserRepository userRepository) {
		//super();
		this.userRepository = userRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		net.TammamDarwish.springboot_blog_webApp.entity.User user = userRepository.findByEmail(email);
		if (user!=null)
		{
			
			org.springframework.security.core.userdetails.User authenticatedUser = 
					new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), 
							user.getRoles().stream().map((role)-> new SimpleGrantedAuthority(role.getName()))
							.collect(Collectors.toList())
					);
			
			return authenticatedUser;
					
		}
		
		
		else {
			throw new UsernameNotFoundException ("Invalid username and password");
		}
		
			
	}

	


}
