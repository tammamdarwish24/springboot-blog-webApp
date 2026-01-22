package net.TammamDarwish.springboot_blog_webApp.dto;

import java.time.LocalDateTime;

public class CommentDto {

	private Long id;
	private String name;
	private String email;
	private String content;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	
	public CommentDto(Long id, String name, String email, String content, LocalDateTime createdOn,
			LocalDateTime updatedOn) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.content = content;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
	
	public CommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentDto(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.email = builder.email;
		this.content = builder.content;
		this.createdOn = builder.createdOn;
		this.updatedOn = builder.updatedOn;
	}
     public static Builder builder()
     {
    	 return new Builder();
     }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public static final class Builder
	{
		private Long id;
		private String name;
		private String email;
		private String content;
		private LocalDateTime createdOn;
		private LocalDateTime updatedOn;
		
		public Builder id(Long id)
		{
			this.id=id;
			return this;
		}
		public Builder name(String name)
		{
			this.name=name;
			return this;
		}
		public Builder email(String email)
		{
			this.email=email;
			return this;
		}
		public Builder content(String content)
		{
			this.content=content;
			return this;
		}
		public Builder createdOn(Long id)
		{
			this.id=id;
			return this;
		}
		public Builder createdOn(LocalDateTime createdOn)
		{
			this.createdOn=createdOn;
			return this;
		}
		public Builder updatedOn(LocalDateTime updatedOn)
		{
			this.updatedOn=updatedOn;
			return this;
		}
		public CommentDto build() {
			return new CommentDto(this);
		}
	}
}
