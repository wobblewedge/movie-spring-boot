package io.javabrains.moviecatalogservice.models;

public class Movie {

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String name;
	private String id;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String description;
	
	public Movie() {}
	public Movie(String name, String id, String description) {
		super();
		this.name = name;
		this.id = id;
		this.description = description;
	}
	
	
}
