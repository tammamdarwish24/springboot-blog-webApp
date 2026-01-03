package net.TammamDarwish.springboot_blog_webApp.dto;

import java.time.LocalDateTime;

public class PostDto {

	private Long id;
	private String title;
	private String url;
	private String content;
	private String shortDescription;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	public PostDto(Long id, String title, String url, String content, String shortDescription, LocalDateTime createdOn,
			LocalDateTime updatedOn) {
		//super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.content = content;
		this.shortDescription = shortDescription;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostDto(Builder builder) {
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
	public static final class Builder
	{
		private Long id;
		private String title;
		private String url;
		private String content;
		private String shortDescription;
		private LocalDateTime createdOn;
		private LocalDateTime updatedOn;
	private Builder()
	{
		
	}
	
	public Builder id(Long id)
	{
		this.id= id;
		return this;
		
	}
	public Builder title (String title)
	{
	  this .title = title;
	  return this;
	}
	public Builder content (String content)
	{
	  this .content = content;
	  return this;
	}
	
	public Builder url (String url)
	{
	  this.url = url;
	  return this;
	}
	public Builder shortDescription(String shortDescription)
	{
		this.content=content;
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
      
	public PostDto build()
	{
		return new PostDto(this);
	}
	
	}
	
}
