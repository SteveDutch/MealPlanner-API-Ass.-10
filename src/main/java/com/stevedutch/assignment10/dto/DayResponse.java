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
	
	private Meal meal;
	private List<Meal> meals = new ArrayList<Meal>();
	private Nutrients nutrients; 
	


//	@Value("${key.value}")
//	private String keyValue;
	
	@Autowired
	ApiService apiService = new ApiService();



//	public DayResponse(String id, String imageType, String title, String readyInMinutes, String servings,
//			String sourceUrl) {
//		super();
//		this.id = id;
//		this.imageType = imageType;
//		this.title = title;
//		this.readyInMinutes = readyInMinutes;
//		this.servings = servings;
//		this.sourceUrl = sourceUrl;
//	}


	public DayResponse() {
		// TODO Auto-generated constructor stub
	}


	public DayResponse(DayResponse body) {
		// TODO Auto-generated constructor stub
	}


	public Meal getMeal() {
		return meal;
	}


	public void setMeal(Meal meal) {
		this.meal = meal;
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

		// transferred to ApiService
//	public ResponseEntity<DayResponse> callApiExample (Integer numCalories, String diet, 
//			String exclusions) {
//		RestTemplate rt = new RestTemplate();
//		System.out.println(apiService.getKeyValue());
//		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
//									  .queryParam("apiKey", apiService.getKeyValue())
//									  .queryParam("timeFrame", "day")
//									  .queryParam("targetCalories", numCalories)
//									  .queryParam("diet", diet)
//									  .queryParam("intolerances", exclusions)
//									  .build()
//									  .toUri();
//		
//		ResponseEntity<DayResponse> response = rt.getForEntity(uri, DayResponse.class);
//	//	DayResponse dayMealPlan = new DayResponse(response.getBody();
//
//		System.out.println(response.getBody());
//		System.out.println(response);
//		System.out.println(rt.getForEntity(uri, String.class));
//		return response;
//	}


	


}
