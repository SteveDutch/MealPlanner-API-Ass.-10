package com.stevedutch.assignment10.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.stevedutch.assignment10.dto.WeekResponse;

class WeekResponseTest {

	@Test
	void test() {
		WeekResponse sut = new WeekResponse();
		sut.callApiExampleWeek(1500, "paleo", "gluten");
		System.out.println(sut);
	}

}
