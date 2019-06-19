package io.javabrains.moviecatalogservice.models;

public class CatalogItem {
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String name;
	private int rating;
	private String description;
	
	public CatalogItem(String name, String description, int rating) {
		super();
		this.name = name;
		this.rating = rating;
		this.description = description;
	}
	
	
}
