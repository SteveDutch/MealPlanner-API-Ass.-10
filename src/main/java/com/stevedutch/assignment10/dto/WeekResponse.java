package com.stevedutch.assignment10.dto;

import org.springframework.stereotype.Component;

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
