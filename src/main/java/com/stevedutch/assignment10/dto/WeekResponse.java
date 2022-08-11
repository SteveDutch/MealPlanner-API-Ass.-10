package com.stevedutch.assignment10.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.stevedutch.assignment10.service.ApiService;

@Component
public class WeekResponse {

	private Week week;

	public WeekResponse() {
	}

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}

}
