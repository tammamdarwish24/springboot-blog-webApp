package net.TammamDarwish.springboot_blog_webApp.service;

import java.util.List;

import net.TammamDarwish.springboot_blog_webApp.dto.PostDto;

public interface PostService {

	List<PostDto> findAllPosts();
	
}
