package net.TammamDarwish.springboot_blog_webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import net.TammamDarwish.springboot_blog_webApp.dto.CommentDto;
import net.TammamDarwish.springboot_blog_webApp.dto.PostDto;
import net.TammamDarwish.springboot_blog_webApp.service.CommentService;
import net.TammamDarwish.springboot_blog_webApp.service.PostService;
@Controller
public class CommentController {

	private CommentService commentService;
	private PostService    postService;

	@Autowired
	public CommentController(CommentService commentService,PostService    postService) {
		// super();
		this.commentService = commentService;
		this.postService=postService;
	}

// handler method to save comment 
	@PostMapping("/{postUrl}/comments")
	public String createComment(@PathVariable("postUrl") String postUrl, Model model,
			@Valid@ModelAttribute("commentDto") CommentDto commentDto,BindingResult result) {
	    PostDto findPostByUrl = postService.findPostByUrl(postUrl);	    
		if(result.hasErrors())
		{
			model.addAttribute("commentDto", commentDto);
			model.addAttribute("post", findPostByUrl);
			return "blog/blog_post";
		}
		else
		
		commentService.createComment(postUrl, commentDto);
		
		return "redirect:/post/" + postUrl;
	}
}
