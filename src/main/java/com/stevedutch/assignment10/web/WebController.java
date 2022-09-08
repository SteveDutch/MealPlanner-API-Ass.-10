package com.stevedutch.assignment10.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.stevedutch.assignment10.dto.DayResponse;
import com.stevedutch.assignment10.dto.WeekResponse;
import com.stevedutch.assignment10.service.ApiService;

@RestController
public class WebController {

	DayResponse day = new DayResponse();
	WeekResponse week = new WeekResponse();
	@Autowired
	ApiService apiService = new ApiService();
	RestTemplate rt = new RestTemplate();

	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
		String timeFrame = "day";
		// funktioniert nicht,weil bereits 1 fehlender Wert reicht, um callDefault() aufzurufen
//		if (numCalories == null || diet == null || exclusions == null) {
//			ResponseEntity<DayResponse> response = rt.getForEntity(apiService.callDefault(timeFrame), DayResponse.class);
//			return response;
//		}
		// Integer maxCal = Integer.valueOf(numCalories); Problem: what if = null? stattdessen Versuch lt. 
		// https://stackoverflow.com/questions/51838827/convert-a-string-representation-of-number-to-integer-in-java-8single-line-with
		Integer maxCal = Optional.ofNullable(numCalories).map(Integer::valueOf).orElse(null);
		ResponseEntity<DayResponse> response = rt.getForEntity(apiService.callApi(maxCal, diet, exclusions, timeFrame),
				DayResponse.class);
		return response;
	}

	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
		String timeFrame = "week";
		// TODO check here! Roches Bug entspricht: 500 / null / null 
		// maybe try optionals ?
//		if (numCalories == null || diet == null || exclusions == null) {
//			ResponseEntity<WeekResponse> response = rt.getForEntity(apiService.callDefault(timeFrame), WeekResponse.class);
//			return response;
//		}
		Integer maxCal = numCaloriesNullCheck(numCalories);
//		Optional<String> opt = Optional.of(numCalories); --> numCalories darf nicht null sein, sonst NullPointeerExceütion TODO Lernertrag

	
		ResponseEntity<WeekResponse> weekMeal = rt.getForEntity(apiService.callApi(maxCal, diet, exclusions, timeFrame),
				WeekResponse.class);
		return weekMeal;
	}

	public Integer numCaloriesNullCheck(String numCalories) {
		Integer maxCal;
		if (numCalories != null) {
			maxCal = Integer.valueOf(numCalories);
		} else { maxCal = 1800;}
		return maxCal;
	}

}
