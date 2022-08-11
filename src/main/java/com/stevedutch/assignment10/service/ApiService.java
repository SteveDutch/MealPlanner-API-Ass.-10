package com.stevedutch.assignment10.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class ApiService {

	@Value("${key.value}")
	private String keyValue;

	public URI callApi(Integer numCalories, String diet, String exclusions, String timeFrame) {

		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
				.queryParam("apiKey", keyValue).queryParam("timeFrame", timeFrame)
				.queryParam("targetCalories", numCalories).queryParam("diet", diet)
				.queryParam("intolerances", exclusions).build().toUri();
		return uri;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

}
