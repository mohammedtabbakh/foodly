package com.example.foodly.foodly.MealSuggest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.example.foodly.foodly.Meal.MealName;
import com.example.foodly.foodly.Meal.adapter.RecyclerAdapter;
import com.example.foodly.foodly.Meal.adapter.models.MealData;
import com.example.foodly.foodly.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MealSuggest extends Fragment {

    RecyclerView mRecyclerView;
    List<MealData> MealSuggestedList;
    MealData mMealData;
    Spinner spinner;
    ChipGroup chipGroup;
    Button addButton;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view= inflater.inflate(R.layout.meal_suggest, container, false);

        addButton=view.findViewById(R.id.addButton);
        chipGroup=view.findViewById(R.id.chip_group);
        spinner= view.findViewById(R.id.spinner);
        mRecyclerView = view.findViewById(R.id.suggest_recycler);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(view.getContext(), 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        MealSuggestedList = new ArrayList<>();

        mMealData = new MealData("كبة",
                R.drawable.keba);
        MealSuggestedList.add(mMealData);

        mMealData = new MealData("فاصولية بيضاء",
                R.drawable.fasolie);
        MealSuggestedList.add(mMealData);

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(view.getContext(), MealSuggestedList);
        mRecyclerView.setAdapter(recyclerAdapter);


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
                Chip chip= new Chip(spinner.getContext());
                chip.setText(spinner.getSelectedItem().toString());
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

        return view;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("الوجبات المقترحة");
    }


}
