package net.TammamDarwish.springboot_blog_webApp.service;

import java.util.List;

import net.TammamDarwish.springboot_blog_webApp.dto.CommentDto;

public interface CommentService {
	
	void createComment(String postUrl,CommentDto commentDto);

	List<CommentDto> findAllComments();

}
