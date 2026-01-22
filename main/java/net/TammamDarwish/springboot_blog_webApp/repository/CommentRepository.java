package net.TammamDarwish.springboot_blog_webApp.repository;
import net.TammamDarwish.springboot_blog_webApp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CommentRepository extends JpaRepository<Comment,Long>{
	

}
