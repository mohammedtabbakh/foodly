package com.example.foodly.foodly.Meal;


import android.os.Bundle;


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
                R.drawable.rose);
        mMealList.add(mMealData);

        mMealData = new MealData("شكليطة",
                R.drawable.keba);
        mMealList.add(mMealData);

        mMealData = new MealData("نزار",
                R.drawable.rose);
        mMealList.add(mMealData);

        mMealData = new MealData("مهند",
                R.drawable.keba);
        mMealList.add(mMealData);

        mMealData = new MealData("يامن",
                R.drawable.rose);
        mMealList.add(mMealData);

        mMealData = new MealData("ريم",
                R.drawable.keba);
        mMealList.add(mMealData);

        mMealData = new MealData("محمد",
                R.drawable.keba);
        mMealList.add(mMealData);






        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(MealName.this, mMealList);
        mRecyclerView.setAdapter(recyclerAdapter);

    }
}
