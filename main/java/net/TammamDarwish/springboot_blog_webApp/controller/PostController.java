package net.TammamDarwish.springboot_blog_webApp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.TammamDarwish.springboot_blog_webApp.dto.PostDto;
import net.TammamDarwish.springboot_blog_webApp.entity.Post;
import net.TammamDarwish.springboot_blog_webApp.mapper.PostMapper;
import net.TammamDarwish.springboot_blog_webApp.repository.PostRepository;
import net.TammamDarwish.springboot_blog_webApp.service.PostService;

@Controller
public class PostController {
	
	private PostService postService;

	public PostController(PostService postService) {
		
		this.postService = postService;
	}
     //create Handler Method to handle Model and view GET the request and return Model and view
	@GetMapping("/admin/posts")
	public String posts(Model model)
	{
		List<PostDto> posts = postService.findAllPosts();
		model.addAttribute("posts", posts);
		return "/admin/posts";
		
	}
	// create a handler method to handle a new Post request.
	@GetMapping("/admin/posts/newpost")
	public String newPostForm(Model model)
	{
		PostDto  postDto = new PostDto();
		model.addAttribute("postDto", postDto);
		
		return "admin/create_post";
	}
	// in the PostDto should be an empty constructor.
	// to bind the form data we should use postDto object 
	// handler method to handle form submit request
	
      @PostMapping("/admin/posts")
      public String createPost(@ModelAttribute PostDto postDto)
      {
    	  postDto.setUrl(getUrl(postDto.getTitle())) ;
    	  postService.createPost(postDto);
    	  return "redirect:/admin/posts";
      }
	   private static String getUrl(String postTitle)
	   {
		  //oops-concept-explained
		   String title = postTitle.trim().toLowerCase();
		   String url = title.replaceAll("\\s+", "-");
		   url.replaceAll("[a-zA-Z0-9]","-");
		   return url;
		   
		   
	   }
      
}
