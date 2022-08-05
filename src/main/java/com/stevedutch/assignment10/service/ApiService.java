package com.stevedutch.assignment10.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.stevedutch.assignment10.domain.DayResponse;

@Component
public class ApiService {
	
	@Value("${key.value}")
	private String keyValue;

	
	public ResponseEntity<String> callApi (Integer numCalories, String diet, 
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
		
		ResponseEntity<String> response = rt.getForEntity(uri, String.class);
//	//	DayResponse dayMealPlan = new DayResponse(response.getBody();
//
		System.out.println(response.getBody());
//		System.out.println(response);
//		System.out.println(rt.getForEntity(uri, String.class));
		return response;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

}
