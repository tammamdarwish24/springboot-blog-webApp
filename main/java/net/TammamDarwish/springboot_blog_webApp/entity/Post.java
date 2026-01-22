package net.TammamDarwish.springboot_blog_webApp.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "posts",schema="MYBlogWebApp")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String title;
	
	private String url;
	@Column(nullable=false)
	@Lob
	private String content;
	private String shortDescription;
	@CreationTimestamp
	private LocalDateTime createdOn;
	@UpdateTimestamp
	private LocalDateTime updatedOn;
	@OneToMany(mappedBy="post" ,cascade = CascadeType.REMOVE)
	private Set<Comment> comments = new HashSet<>();
	
	public Post(Long id, String title, String url, String content, String shortDescription, LocalDateTime createdOn,
			LocalDateTime updatedOn) {
		
		this.id = id;
		this.title = title;
		this.url = url;
		this.content = content;
		this.shortDescription = shortDescription;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
	public Post()
	{
		super();
	}

	public Post(Builder builder) {
		this.id = builder.id;
		this.title = builder.title;
		this.url = builder.url;
		this.content = builder.content;
		this.shortDescription = builder.shortDescription;
		this.createdOn = builder.createdOn;
		this.updatedOn = builder.updatedOn;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
	public static Builder builder()
	{
		return new Builder();
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", url=" + url + ", content=" + content + ", shortDescription="
				+ shortDescription + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}
	
	public static final class Builder
	{
		private Long id;
		private String title;
		private String url;
		private String content;
		private String shortDescription;
		private LocalDateTime createdOn;
		private LocalDateTime updatedOn;
		

	

	
	public Builder id(Long id)
	{
		this.id = id;
		return this;
	}
	public Builder title(String title)
	{
		this.title=title;
		return this;
	}
	public Builder url(String url)
	{
		this.url= url;
		return this;
	}
	public Builder content(String content)
	{
		this.content = content;
		return this;
	}
	public Builder shortDescription(String shortDescription)
	{
		this.shortDescription = shortDescription;
		return this;
	}
	public Builder createdOn(LocalDateTime createdOn)
	{
		this.createdOn = createdOn;
		return this;
	}
	public Builder updatedOn(LocalDateTime updatedOn)
	{
		this.updatedOn = updatedOn;
		return this;
	}
	
	public Post build()
	{
		return new Post (this);
	}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
