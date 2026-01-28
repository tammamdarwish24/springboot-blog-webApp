package net.TammamDarwish.springboot_blog_webApp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import net.TammamDarwish.springboot_blog_webApp.dto.CommentDto;
import net.TammamDarwish.springboot_blog_webApp.dto.PostDto;
import net.TammamDarwish.springboot_blog_webApp.entity.Post;
import net.TammamDarwish.springboot_blog_webApp.mapper.PostMapper;
import net.TammamDarwish.springboot_blog_webApp.repository.PostRepository;
import net.TammamDarwish.springboot_blog_webApp.service.CommentService;
import net.TammamDarwish.springboot_blog_webApp.service.PostService;

@Controller
public class PostController {
	
	private PostService postService;
	private CommentService commentService;

	public PostController(PostService postService, CommentService commentService) {
		
		this.postService = postService;
		this.commentService=commentService;
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
      public String createPost(@Valid @ModelAttribute("postDto") PostDto postDto,BindingResult result,
    		  Model model)
      {
    	  if (result.hasErrors())
    	  {
    		  model.addAttribute("postDto", postDto);
    		  return "admin/create_post";
    	  }
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
	   @GetMapping("/admin/posts/{postId}/edit")
	   public String editPostForm(@PathVariable("postId") Long postId,Model model)
	   {
		   PostDto postDto=postService.findPostById(postId);
		   model.addAttribute("postDto", postDto);
		   return "admin/edit_post";
	   }
	  /* we should make the validation in the PostDto object because we use it as object  in the 
	   * create_post html file 
	   * 
	   * <form role="form" method="post" th:action=@{/admin/posts}
						th:object="${postDto}">*/
	   /*to make validation in spring mvc */
	   /*1-add the dependency in the maven (pom.xml)
	    * 2-add NotEmpty annotation above the the fields in the POSTDTO object
	    * 3-Enable annotation in the handler method @Valid @ModelAttribute("postDto") PostDto postDto
	    * 4-use Binding result object and return to the same page if there is any error "admin/create_post" */
      
	   // handler method to handle edit post form submit
	   /* we need to store these updated information in the database*/
	   
	   @PostMapping("/admin/posts/{postId}")
	   public String updatePost(@PathVariable("postId")Long postId,@Valid@ModelAttribute("postDto")PostDto postDto,
			   Model model,BindingResult result)
	   {
		   if (result.hasErrors())
		   {
			   model.addAttribute("PostDto", postDto);
			   return "admin/edit_post";
		   }
		   postDto.setId(postId);
		   postService.updatePost(postDto);
		   return "redirect:/admin/posts";
		  
	   }
	   @GetMapping("/admin/posts/{postUrl}/view")
	   public String viewPost(@PathVariable ("postUrl")String postUrl,Model model)
	   {
		   PostDto postDto = postService.findPostByUrl(postUrl);
		   model.addAttribute("postDto", postDto);
		   
		  return "/admin/view_post";
		   
	   }
	   //handler method to handle 
	   
	   
	   @GetMapping("/admin/posts/{postId}/delete")
	   public String deletePost(@PathVariable("postId") Long postId )
	   {
		   postService.deletePost(postId);
		   return "redirect:/admin/posts";
	   }
	   //localhost:8080/admin/posts/search?query=
	   @GetMapping("/admin/posts/search")
	   public String searchPosts(@RequestParam(value = "query")String query , Model model)
	   {
		List<PostDto> postDtos = postService.searchPosts(query);
		model.addAttribute("posts", postDtos);
		return "admin/posts";
		   
	   }
	   // handler method to handle view Post Request.
	   @GetMapping("/post/{postUrl}")
	   private String showPost(@PathVariable("postUrl")String postUrl,Model model)
	   {
		   PostDto post = postService.findPostByUrl(postUrl);
		  CommentDto commentDto = new CommentDto();
		   model.addAttribute("commentDto", commentDto);
		   model.addAttribute("post", post);
		   return "blog/blog_post";
	   }
	   
	   // handler method to handle list comments request.
	   @GetMapping("/admin/posts/comments")
	   public String postComments(Model model)
	   {
		List<CommentDto>  comments =  commentService.findAllComments();
		model.addAttribute("comments", comments);
		return "admin/comments";
	   }
	   // handler method to handle delete button.
	   
	   @GetMapping("/admin/posts/comments/{commentId}")
	   public String deleteComment(@PathVariable("commentId")Long id )
	   { 
		   commentService.delete(id);
		return "redirect:/admin/posts/comments" ;
		   
	   }
	   
 
}


