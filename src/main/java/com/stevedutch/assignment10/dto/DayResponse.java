package com.stevedutch.assignment10.dto;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.stevedutch.assignment10.service.ApiService;

@Component
public class DayResponse {

//	private Meal meal;
	private List<Meal> meals = new ArrayList<Meal>();
	private Nutrients nutrients;

	@Autowired
	ApiService apiService = new ApiService();

	public DayResponse() {

	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public Nutrients getNutrients() {
		return nutrients;
	}

	public void setNutrients(Nutrients nutrients) {
		this.nutrients = nutrients;
	}

	@Override
	public String toString() {
		return "DayResponse [meals=" + meals + ", nutrients=" + nutrients + ", apiService=" + apiService + "]";
	}

}
