package com.stevedutch.assignment10.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stevedutch.assignment10.domain.DayResponse;
import com.stevedutch.assignment10.domain.WeekResponse;

@RestController
public class WebController {
	
	DayResponse day = new DayResponse();
	
	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, 
			String exclusions) {

		
				return null;
		
	}

	@GetMapping("mealplanner/day")
	public ResponseEntity<String> getDayMeals(String numCalories, String diet, 
			String exclusions) {
					Integer maxCal = Integer.valueOf(numCalories);
					ResponseEntity<String> dayMeal= day.callApiExample(maxCal, diet, exclusions);
					return dayMeal;
		
	}

}
