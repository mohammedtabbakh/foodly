package com.example.foodly.foodly.Meal;


import android.os.Bundle;


import com.example.foodly.foodly.Meal.adapter.RecyclerAdapter;

import com.example.foodly.foodly.Meal.models.MealData;
import com.example.foodly.foodly.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MealName extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<MealData> mMealList;
    MealData mMealData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_name);

        mRecyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(MealName.this, 3);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mMealList = new ArrayList<>();

        mMealData = new MealData("كبة",
                R.drawable.keba);
        mMealList.add(mMealData);

        mMealData = new MealData("فاصولية بيضاء",
                R.drawable.fasolie);
        mMealList.add(mMealData);





        mMealData = new MealData("فريكة",
                R.drawable.frike);
        mMealList.add(mMealData);

        mMealData = new MealData("يبرق",
                R.drawable.yabraq);
        mMealList.add(mMealData);





        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(MealName.this, mMealList);
        mRecyclerView.setAdapter(recyclerAdapter);

    }
}
