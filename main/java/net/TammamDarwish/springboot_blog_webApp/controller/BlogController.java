package net.TammamDarwish.springboot_blog_webApp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.TammamDarwish.springboot_blog_webApp.dto.PostDto;
import net.TammamDarwish.springboot_blog_webApp.service.PostService;

@Controller
public class BlogController {

	private PostService postService;

	public BlogController(PostService postService) {
		
		this.postService = postService;
	}
	// handler method to handle 
	// http://localhost:8080/-- this is basically the root
	@GetMapping("/")
	public String viewBlogPost(Model model)
	{
		List<PostDto> postsResponse = postService.findAllPosts();
		model.addAttribute("posts", postsResponse);
		return "blog/view_posts";
		
	} 
	// http://localhost:8080/page/search?query=java
	   @GetMapping("/page/search")
	   public String searchPosts(@RequestParam(value = "query")String query , Model model)
	   {
		   
		List<PostDto> postDtos = postService.searchPosts(query);
		model.addAttribute("posts", postDtos);
		return "blog/view_posts";
		   
	   }

	
}
