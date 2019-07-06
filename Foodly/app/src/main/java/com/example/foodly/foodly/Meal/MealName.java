package com.example.foodly.foodly.Meal;


import android.os.Bundle;


import com.example.foodly.foodly.Api.ApiClient;
import com.example.foodly.foodly.Api.ApiEndPoints;
import com.example.foodly.foodly.Meal.adapter.RecyclerAdapter;

import com.example.foodly.foodly.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import Models.Meal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MealName extends AppCompatActivity {


    RecyclerView mRecyclerView;
    List<Models.Meal> MealsList;
    Meal mMealData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_name);
        MealsList=new ArrayList<>();

        mRecyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(MealName.this, 3);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        final RecyclerAdapter recyclerAdapter = new RecyclerAdapter(MealName.this, MealsList);
        mRecyclerView.setAdapter(recyclerAdapter);
        ApiEndPoints apiEndPoints = ApiClient.getClient().create(ApiEndPoints.class);


        apiEndPoints.GetAllMeals().enqueue(new Callback<List<Meal>>() {
            @Override
            public void onResponse(Call<List<Meal>> call, Response<List<Meal>> response) {
                MealsList=response.body();
                final RecyclerAdapter recyclerAdapter = new RecyclerAdapter(MealName.this, MealsList);
                mRecyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void onFailure(Call<List<Meal>> call, Throwable t) {
                MealsList.add( new Meal("فريكة"));
                MealsList.add(new Meal("فاصوليا"));
            }
        });

    }
}
