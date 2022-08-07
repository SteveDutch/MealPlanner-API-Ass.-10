package com.stevedutch.assignment10.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.stevedutch.assignment10.dto.DayResponse;

@Component
public class ApiService {
	
	@Value("${key.value}")
	private String keyValue;

	
	public URI callApi (Integer numCalories, String diet, 
			String exclusions, String timeFrame) {
		RestTemplate rt = new RestTemplate();
		System.out.println(keyValue);
		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
									  .queryParam("apiKey", keyValue)
									  .queryParam("timeFrame", timeFrame)
									  .queryParam("targetCalories", numCalories)
									  .queryParam("diet", diet)
									  .queryParam("intolerances", exclusions)
									  .build()
									  .toUri();
		// just for testing
//		ResponseEntity<String> response = rt.getForEntity(uri, String.class);
//		ResponseEntity<DayResponse> responseDayResponse = rt.getForEntity(uri, DayResponse.class);
////		DayResponse dayMealPlan = new DayResponse(response.getBody(), id, imageType, title, readyInMinutes, servings, sourceUrl);
////
//		System.out.println("Hilsen fra ApiService class AND s you're shown: ResponseEntity<String> response.getBody " + response.getBody());
////		System.out.println(response);
//		System.out.println(rt.getForEntity(uri, String.class));
		return uri;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

}
