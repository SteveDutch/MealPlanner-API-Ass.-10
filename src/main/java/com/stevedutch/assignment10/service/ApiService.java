package com.stevedutch.assignment10.service;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
  
@Component
public class ApiService {

	@Value("${key.value}")
	private String keyValue;
	RestTemplate rt = new RestTemplate();
	
	// TODO wenn keine if-Bedingungsprüfung, brauche ich diese Methode auch nicht mehr
	public URI callDefault(String timeFrame) {
		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
				.queryParam("apiKey", keyValue)
				.queryParam("timeFrame", timeFrame)
				.build().toUri();
		
		return uri ;
	}

	public URI callApi(Integer numCalories, String diet, String exclusions, String timeFrame) {
		// TODO check: maxCalories & targetCalories at spoonacular
		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
				.queryParam("apiKey", keyValue)
				.queryParam("timeFrame", timeFrame)
				.queryParamIfPresent("targetCalories", Optional.ofNullable(numCalories))
				.queryParamIfPresent("diet", Optional.ofNullable(diet))
				//.queryParam("targetCalories", numCalories).queryParam("diet", diet)
				.queryParamIfPresent("intolerances", Optional.ofNullable(exclusions))
				//.queryParam("intolerances", exclusions)
				.build().toUri();
		return uri;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

}
