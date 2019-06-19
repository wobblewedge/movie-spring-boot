package io.javabrains.moviecatalogservice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
			//get all rated movie ids 
			//for each, call move info service and get details
			//put em together 
			//WebClient is the asynch specification that will be replacing RestTemplate in future spring
			//boot versions. Reactive programming.			
			
			List<Rating> ratings = Arrays.asList(
						new Rating("ID", 2),
						new Rating("ID2", 5)
						);
		return	ratings.stream().map(rating -> {
		Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getId(), Movie.class);
			
		/*
			Movie movie = webClientBuilder.build()
				.get() //RequestHeadersURI
				.uri("http://localhost:8081/movies/"+rating.getId()) //build uri
				.retrieve() //ResponseSpec
				.bodyToMono(Movie.class) //Mono<Movie>
				.block();
		*/	
		return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
		})
		.collect(Collectors.toList());
			
	}
}
