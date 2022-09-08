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

	public URI callApi(Integer numCalories, String diet, String exclusions, String timeFrame) {
		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
				.queryParam("apiKey", keyValue).queryParam("timeFrame", timeFrame)
				.queryParamIfPresent("targetCalories", Optional.ofNullable(numCalories))
				.queryParamIfPresent("diet", Optional.ofNullable(diet))
				.queryParamIfPresent("intolerances", Optional.ofNullable(exclusions))
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
