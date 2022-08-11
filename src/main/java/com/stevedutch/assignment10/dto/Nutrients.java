package com.stevedutch.assignment10.dto;

public class Nutrients {

	private String calories;
	private String protein;
	private String fat;
	private String carbohydrates;

	public Nutrients(String calories, String protein, String fat, String carbohydrates) {
		super();
		this.calories = calories;
		this.protein = protein;
		this.fat = fat;
		this.carbohydrates = carbohydrates;
	}

	public Nutrients() {

	}

	public String getCalories() {
		return calories;
	}

	public void setCalories(String calories) {
		this.calories = calories;
	}

	public String getProtein() {
		return protein;
	}

	public void setProtein(String protein) {
		this.protein = protein;
	}

	public String getFat() {
		return fat;
	}

	public void setFat(String fat) {
		this.fat = fat;
	}

	public String getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(String carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	@Override
	public String toString() {
		return "Nutrients [calories=" + calories + ", protein=" + protein + ", fat=" + fat + ", carbohydrates="
				+ carbohydrates + "]";
	}

}
