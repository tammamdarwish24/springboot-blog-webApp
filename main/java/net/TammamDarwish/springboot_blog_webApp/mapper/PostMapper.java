package net.TammamDarwish.springboot_blog_webApp.mapper;

import java.util.stream.Collectors;

import net.TammamDarwish.springboot_blog_webApp.dto.PostDto;
import net.TammamDarwish.springboot_blog_webApp.entity.Post;

public class PostMapper {
	
	public  static PostDto mapToPostDto(Post post)
	{
		PostDto postDto =  PostDto.builder().
				id(post.getId())
				.title(post.getTitle()).
				 url(post.getUrl())
				.content(post.getContent()).
				shortDescription(post.getShortDescription()).
				createdOn(post.getCreatedOn()).
				updatedOn(post.getUpdatedOn()).commentsDto(post.getComments().stream().map((comment)->
				CommentMapper.mapToCommentDto(comment)).collect(Collectors.toSet())).build();
		return postDto;
				
				
				
	}
	
	public static Post mapToPost(PostDto postDto)
	{
		Post post = Post.builder().
				    id(postDto.getId()).
				    title(postDto.getTitle()).
				    url(postDto.getUrl()).
				    content(postDto.getContent()).
				    shortDescription(postDto.getShortDescription()).
				    createdOn(postDto.getCreatedOn()).updatedOn(postDto.getUpdatedOn()).build();
				    
				    return post;
	}

}
