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
public class MealplannerController {

	DayResponse day = new DayResponse();
	WeekResponse week = new WeekResponse();
	@Autowired
	ApiService apiService = new ApiService();
	RestTemplate rt = new RestTemplate();

	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
		String timeFrame = "day";
		// thanks to
		// stackoverflow.com/questions/51838827/convert-a-string-representation-of-number-to-integer-in-java-8single-line-with
		Integer maxCal = Optional.ofNullable(numCalories).map(Integer::valueOf).orElse(null);
		ResponseEntity<DayResponse> response = rt.getForEntity(apiService.callApi(maxCal, diet, exclusions, timeFrame),
				DayResponse.class);
		return response;
	}

	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
		String timeFrame = "week";
		Integer maxCal = Optional.ofNullable(numCalories).map(Integer::valueOf).orElse(null);
		ResponseEntity<WeekResponse> weekMeal = rt.getForEntity(apiService.callApi(maxCal, diet, exclusions, timeFrame),
				WeekResponse.class);
		return weekMeal;
	}

}
