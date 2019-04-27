package com.example.foodly.foodly.Meal;

  public class MealData {
    private String MealName;
    private int MealImage;

    public MealData(String mealName, int mealImage) {
        this.MealName = mealName;
        this.MealImage = mealImage;
    }

    public String getMealName() {
        return MealName;
    }

    public int getMealImage() {
        return MealImage;
    }
}
