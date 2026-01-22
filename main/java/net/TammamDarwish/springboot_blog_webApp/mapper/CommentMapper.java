package net.TammamDarwish.springboot_blog_webApp.mapper;



import net.TammamDarwish.springboot_blog_webApp.dto.CommentDto;
import net.TammamDarwish.springboot_blog_webApp.entity.Comment;

public class CommentMapper {
	
	public static CommentDto mapToCommentDto(Comment comment)
	{
		CommentDto commentDto = CommentDto.builder().id(comment.getId()).
				name(comment.getName()).content(comment.getContent()).
				createdOn(comment.getCreatedOn()).updatedOn(comment.getUpdatedOn()).build();
		return commentDto;	
		
	}

	public static Comment mapToComment(CommentDto commentDto)
	{
		Comment comment = Comment.builder().id(commentDto.getId()).
				name(commentDto.getName()).content(commentDto.getContent()).
				createdOn(commentDto.getCreatedOn()).updatedOn(commentDto.getUpdatedOn()).build();
		return comment;
	}
}
