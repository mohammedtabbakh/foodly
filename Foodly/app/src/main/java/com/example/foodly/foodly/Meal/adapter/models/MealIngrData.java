package com.example.foodly.foodly.Meal.adapter.models;

  public class MealIngrData {
    private String MealingrName;
    private int MealSelected;

      public String getMealingrName() {
          return MealingrName;
      }

      public int getMealSelected() {
          return MealSelected;
      }

      public MealIngrData(String mealingrName, int mealSelected) {
          MealingrName = mealingrName;
          MealSelected = mealSelected;
      }
  }
