package net.TammamDarwish.springboot_blog_webApp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import net.TammamDarwish.springboot_blog_webApp.dto.CommentDto;
import net.TammamDarwish.springboot_blog_webApp.entity.Comment;
import net.TammamDarwish.springboot_blog_webApp.entity.Post;
import net.TammamDarwish.springboot_blog_webApp.mapper.CommentMapper;
import net.TammamDarwish.springboot_blog_webApp.repository.CommentRepository;
import net.TammamDarwish.springboot_blog_webApp.repository.PostRepository;
import net.TammamDarwish.springboot_blog_webApp.repository.UserRepository;
import net.TammamDarwish.springboot_blog_webApp.service.CommentService;
import net.TammamDarwish.springboot_blog_webApp.util.SecurityUtils;
@Service
public class CommentServiceImpl implements CommentService{
	private CommentRepository commentRepository;
	private PostRepository postRepository;
	private UserRepository userRepository;
	@Autowired
	public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository,
			UserRepository userRepository) {
		super();
		this.commentRepository = commentRepository;
		this.postRepository = postRepository;
		this.userRepository=userRepository;
	}

	

	@Override
	public void createComment(String postUrl, CommentDto commentDto) {
		Post post = postRepository.findByUrl(postUrl).get();
		Comment comment = CommentMapper.mapToComment(commentDto);
		comment.setPost(post);
		commentRepository.save(comment);
		
		
		
	}



	@Override
	public List<CommentDto> findAllComments() {
		List<Comment> commentList = commentRepository.findAll();
		
		return commentList.stream().map(comment->CommentMapper.mapToCommentDto(comment)).collect(Collectors.toList());
	}



	@Override
	public void delete(Long id) {
		commentRepository.deleteById(id);

	}



	@Override
	public List<CommentDto> findCommentByPost() {
		String email =SecurityUtils.getCurrentUser().getUsername();
		
		net.TammamDarwish.springboot_blog_webApp.entity.User createdBy = userRepository.findByEmail(email);
		
		Long userId = createdBy.getId();
		List<Comment> comment = commentRepository.findCommentByPost(userId);
		List<CommentDto> commentDto = comment.stream().map((coment)->
		CommentMapper.mapToCommentDto(coment)).collect(Collectors.toList());
		
		
		return commentDto;
	}

}
