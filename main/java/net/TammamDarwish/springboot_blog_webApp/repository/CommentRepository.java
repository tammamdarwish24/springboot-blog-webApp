package net.TammamDarwish.springboot_blog_webApp.repository;
import net.TammamDarwish.springboot_blog_webApp.entity.Comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface CommentRepository extends JpaRepository<Comment,Long>{
	@Query(value = "select c.* from comment c inner join posts p where c.post_id=p.id and p.created_by=:userId",
			nativeQuery=true)
	List<Comment>findCommentByPost(Long userId) ;

}
