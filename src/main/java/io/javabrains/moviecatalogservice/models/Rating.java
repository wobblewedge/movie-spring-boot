package io.javabrains.moviecatalogservice.models;

public class Rating {
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Rating(String id, int rating) {
		super();
		this.id = id;
		this.rating = rating;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	private String id;
	private int rating;

}
