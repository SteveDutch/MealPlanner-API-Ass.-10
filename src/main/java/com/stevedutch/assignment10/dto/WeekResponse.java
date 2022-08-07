package com.stevedutch.assignment10.dto;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.stevedutch.assignment10.service.ApiService;

@Component
public class WeekResponse {
	
	private String id;
	private String imageType;
	private String title;
	private String readyInMinutes;
	private String servings;
	private String sourceUrl;
//	@Value("${key.value}")
//	private String keyValue;

	@Autowired
	ApiService apiService = new ApiService();
	
	public WeekResponse(String id, String title, String imageType, String readyInMinutes, String servings, String sourceUrl) {
		super();
		this.id = id;
		this.imageType = imageType;
		this.title = title;
		this.readyInMinutes = readyInMinutes;
		this.servings = servings;
		this.sourceUrl = sourceUrl;
	}
//	
//	public WeekResponse(String body) {
//		// TODO Auto-generated constructor stub
//	}

	public WeekResponse() {
		// TODO Auto-generated constructor stub
	}

	public ResponseEntity<String> callApiExampleWeek (Integer numCalories, String diet, 
			String exclusions) {
		RestTemplate rt = new RestTemplate();
		System.out.println(apiService.getKeyValue());
		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
									  .queryParam("apiKey", apiService.getKeyValue())
									  .queryParam("targetCalories", numCalories)
									  .queryParam("diet", diet)
									  .queryParam("intolerances", exclusions)								  
									  .build()
									  .toUri();
		
		ResponseEntity<String> response = rt.getForEntity(uri, String.class);
		System.out.println(response);
		System.out.println(response.getBody());
//		WeekResponse responseTest = new WeekResponse(response.getBody());
//		System.out.println(responseTest);
		return response;
	}

}
