package com.app.dto;

public class ImageDataDTO {

	private Long id;
	private String name;
	private String type;

	// Default constructor
	public ImageDataDTO() {
	}

	// Constructor with parameters
	public ImageDataDTO(Long id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	// Getters and Setters
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ImageDataDTO [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
}
