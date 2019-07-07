package com.example.foodly.foodly.MealSuggest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.foodly.foodly.Api.ApiClient;
import com.example.foodly.foodly.Api.ApiEndPoints;
import com.example.foodly.foodly.Meal.MealName;
import com.example.foodly.foodly.Meal.adapter.RecyclerAdapter;

import com.example.foodly.foodly.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import Models.Meal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MealSuggest extends Fragment {

    private RecyclerView SuggestRecyclerView;
    private List<Meal> MealSuggestedList;
    private Meal mealData;
    private Spinner spinner;
    private ChipGroup chipGroup;
    private Button addButton,suggestButton;
    private int myPosition=-1;
    List<Models.Meal> MealsList;
    int i;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view= inflater.inflate(R.layout.meal_suggest, container, false);

        addButton=view.findViewById(R.id.addButton);
        suggestButton=view.findViewById(R.id.suggestButton);
        chipGroup=view.findViewById(R.id.chip_group);
        spinner= view.findViewById(R.id.spinner);
        SuggestRecyclerView = view.findViewById(R.id.suggest_recycler);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(view.getContext(), 2);
        SuggestRecyclerView.setLayoutManager(mGridLayoutManager);

        final ApiEndPoints apiEndPoints = ApiClient.getClient().create(ApiEndPoints.class);

        MealsList = new ArrayList<>();


//        mealData = new Meal("كبة");
//        MealSuggestedList.add(mealData);
//
//        mealData = new Meal("فاصولية بيضاء");
//        MealSuggestedList.add(mealData);
//
//        mealData = new Meal("كبة");
//        MealSuggestedList.add(mealData);
//
//        mealData = new Meal("كبة");
//        MealSuggestedList.add(mealData);
//
//        mealData = new Meal("كبة");
//        MealSuggestedList.add(mealData);




        List<String> ingredients = new ArrayList<>();
        ingredients.add("بندورة");
        ingredients.add("خيار");
        ingredients.add("لحمة");
        ingredients.add("ورق عنب");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(view.getContext(),R.layout.ingredient_spinner,R.id.ingrTv,ingredients);

        spinner.setAdapter(spinnerAdapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = spinner.getSelectedItemPosition();
                if(myPosition == position){
                    return; //do nothing
                }

                myPosition= position;
                Chip chip= new Chip(spinner.getContext());
                chip.setText(spinner.getItemAtPosition(position).toString());
                chip.setCloseIconVisible(true);
                chip.setCheckable(false);
                chip.setClickable(false);

                chip.setOnCloseIconClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Chip chip= (Chip)v;
                        chipGroup.removeView(chip);

                    }
                });

                chipGroup.addView(chip);
                chipGroup.setVisibility(View.VISIBLE);


            }
        });

        suggestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiEndPoints.GetAllMeals().enqueue(new Callback<List<Meal>>() {
                    @Override
                    public void onResponse(Call<List<Meal>> call, Response<List<Meal>> response) {
                        MealsList = response.body();

                        MealSuggestedList = new ArrayList<>();
                        for(i=0;i<5;i++) {
                            MealSuggestedList.add(MealsList.get(i));
                        }
                        final RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getContext(),MealSuggestedList);
                        SuggestRecyclerView.setAdapter(recyclerAdapter);

                    }

                    @Override
                    public void onFailure(Call<List<Meal>> call, Throwable t) {
                        MealsList.add(new Meal("فريكة"));
                        MealsList.add(new Meal("فاصوليا"));
                    }
                });
            }
        });
        return view;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("الوجبات المقترحة");
    }


}
