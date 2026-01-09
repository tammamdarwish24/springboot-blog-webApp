package net.TammamDarwish.springboot_blog_webApp.service;

import java.util.List;

import net.TammamDarwish.springboot_blog_webApp.dto.PostDto;

public interface PostService {

	List<PostDto> findAllPosts();
	void createPost (PostDto postDto);
	PostDto findPostById(Long postId);
	void updatePost(PostDto postDto);
	void deletePost(Long postId);
	PostDto findPostByUrl(String postUrl);
	List<PostDto> searchPosts(String query);
}
