package net.TammamDarwish.springboot_blog_webApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.TammamDarwish.springboot_blog_webApp.entity.Post;

public interface PostRepository extends JpaRepository<Post,Long>{

	Optional<Post>findByUrl(String url);
}
