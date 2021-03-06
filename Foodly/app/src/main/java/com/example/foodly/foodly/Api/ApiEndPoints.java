package com.example.foodly.foodly.Api;

import com.example.foodly.foodly.Order.Order;

import java.util.List;

import Models.Meal;
import Models.MealIngredient;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiEndPoints {
    @GET("Api/Meals")
    Call<List<Meal>> GetAllMeals();
    @GET("api/Meals/{id}/Ingredients")
    Call<List<MealIngredient>> GetMealIngredients(@Path("id") int id);
    @GET("api/Category/{categoryId}/Meals")
    Call<List<Meal>> GetMealsByCategory(@Path("categoryId") int categoryId);
    @POST("api/Orders")
    Call<Order> CreateOrder(@Body Order order);
}
