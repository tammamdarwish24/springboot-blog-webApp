package net.TammamDarwish.springboot_blog_webApp.util;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class SecurityUtils {

	/* this class code used to take logged user Id in the Posts Tab */

	public static User getCurrentUser() {
		Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principle instanceof User) {
			return (User) (principle);

		} else
			return null;
	}
	
	public static String getRole()
	{
		User user = getCurrentUser();
		Collection<GrantedAuthority> authorities= user.getAuthorities();
		for (GrantedAuthority authority:authorities)
		{
			return authority.getAuthority();
		}
		return null;
	}
}