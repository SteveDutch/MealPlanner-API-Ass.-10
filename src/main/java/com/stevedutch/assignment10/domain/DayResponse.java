package com.stevedutch.assignment10.domain;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class DayResponse { 
	private String id;
	private String imageType;
	private String title;
	private String readyInMinutes;
	private String servings;
	private String sourceUrl;

	@Value("${key.value}")
	private String keyValue;



	public DayResponse(String id, String imageType, String title, String readyInMinutes, String servings,
			String sourceUrl) {
		super();
		this.id = id;
		this.imageType = imageType;
		this.title = title;
		this.readyInMinutes = readyInMinutes;
		this.servings = servings;
		this.sourceUrl = sourceUrl;
	}


	public DayResponse() {
		// TODO Auto-generated constructor stub
	}


	public ResponseEntity<DayResponse> callApiExample (Integer numCalories, String diet, 
			String exclusions) {
		RestTemplate rt = new RestTemplate();
		System.out.println(keyValue);
		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
									  .queryParam("apiKey", keyValue)
									  .queryParam("timeFrame", "day")
									  .queryParam("targetCalories", numCalories)
									  .queryParam("diet", diet)
									  .queryParam("intolerances", exclusions)
									  .build()
									  .toUri();
		
		ResponseEntity<DayResponse> response = rt.getForEntity(uri, DayResponse.class);
	//	DayResponse dayMealPlan = new DayResponse(response.getBody();

		System.out.println(response.getBody());
		System.out.println(response);
		System.out.println(rt.getForEntity(uri, String.class));
		return response;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getImageType() {
		return imageType;
	}


	public void setImageType(String imageType) {
		this.imageType = imageType;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getReadyInMinutes() {
		return readyInMinutes;
	}


	public void setReadyInMinutes(String readyInMinutes) {
		this.readyInMinutes = readyInMinutes;
	}


	public String getServings() {
		return servings;
	}


	public void setServings(String servings) {
		this.servings = servings;
	}


	public String getSourceUrl() {
		return sourceUrl;
	}


	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}



}
