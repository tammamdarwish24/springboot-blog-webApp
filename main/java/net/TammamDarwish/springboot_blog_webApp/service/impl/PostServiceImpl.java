package net.TammamDarwish.springboot_blog_webApp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.TammamDarwish.springboot_blog_webApp.dto.PostDto;
import net.TammamDarwish.springboot_blog_webApp.entity.Post;
import net.TammamDarwish.springboot_blog_webApp.entity.User;
import net.TammamDarwish.springboot_blog_webApp.mapper.PostMapper;
import net.TammamDarwish.springboot_blog_webApp.repository.PostRepository;
import net.TammamDarwish.springboot_blog_webApp.repository.UserRepository;
import net.TammamDarwish.springboot_blog_webApp.service.PostService;
import net.TammamDarwish.springboot_blog_webApp.util.SecurityUtils;
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	private UserRepository userRepository;
	
	
	public PostServiceImpl(PostRepository postRepository,UserRepository userRepository) {
		super();
		this.postRepository = postRepository;
		this.userRepository=userRepository;
	}


	@Override
	public List<PostDto> findAllPosts() {
		
		List<Post> list =postRepository.findAll();
		List<PostDto> listDto = list.stream().map((post)->PostMapper.mapToPostDto(post)).collect(Collectors.toList());
		return listDto;
		
	}


	@Override
	public void createPost(PostDto postDto) {
		String email = SecurityUtils.getCurrentUser().getUsername();
		User user = userRepository.findByEmail(email);
		Post post = PostMapper.mapToPost(postDto);
		post.setCreatedBy(user);
		postRepository.save(post);
		
	}


	@Override
	public PostDto findPostById(Long postId) {
	
		Post post = postRepository.findById(postId).get();
		PostDto postDto = PostMapper.mapToPostDto(post);
		return postDto;
	}


	@Override
	public void updatePost(PostDto postDto) {
		String email = SecurityUtils.getCurrentUser().getUsername();
		User user = userRepository.findByEmail(email);
		Post post = PostMapper.mapToPost(postDto);
		post.setCreatedBy(user);
		postRepository.save(post);
		// we can use this save method for both save ans update operation.
		
	}


	@Override
	public void deletePost(Long postId) {
		postRepository.deleteById(postId);
	}


	@Override
	public PostDto findPostByUrl(String postUrl) {
		Post post = postRepository.findByUrl(postUrl).get();
		PostDto postDto = PostMapper.mapToPostDto(post);
		return postDto;
	}


	@Override
	public List<PostDto> searchPosts(String query) {
		List<Post> searchPosts = postRepository.searchPosts(query);
		return searchPosts.stream().map((post)->
		PostMapper.mapToPostDto(post)).collect(Collectors.toList());
	}

}
