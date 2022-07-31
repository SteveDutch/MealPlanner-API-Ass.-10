package com.stevedutch.assignment10.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stevedutch.assignment10.domain.DayResponse;
import com.stevedutch.assignment10.domain.WeekResponse;

@RestController
public class WebController {
	
	DayResponse day = new DayResponse();
	WeekResponse week = new WeekResponse();
	
	@GetMapping("mealplanner/week")
	public ResponseEntity<String> getWeekMeals(String numCalories, String diet, 
			String exclusions) {
					Integer maxCal = Integer.valueOf(numCalories);
					ResponseEntity<String> weekMeal= week.callApiExampleWeek(maxCal, diet, exclusions);
					return weekMeal;
	}
		

	@GetMapping("mealplanner/day")
	public ResponseEntity<String> getDayMeals(String numCalories, String diet, 
			String exclusions) {
					Integer maxCal = Integer.valueOf(numCalories);
					ResponseEntity<String> dayMeal= day.callApiExample(maxCal, diet, exclusions);
					return dayMeal;
		
	}

}
// TODO rt.getBod()
// to get json file 
// private Strings for vorlommende Variablen
// put in DTO or POJO (und callAPiExample in POJO-Service)
// weeks mit DateFormat?
// ggf instruchtion GETMAPPING
// watch video 14-09  zu Ende, von 12:03 ab