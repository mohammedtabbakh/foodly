package com.example.foodly.foodly.Meal;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.foodly.foodly.R;

public class Meal extends Fragment {
    @Nullable

    public ImageView eastBtn,westBtn,healthyBtn,entreesBtn;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.meal, container, false);


        eastBtn= view.findViewById(R.id.east_btn);
        westBtn= view.findViewById(R.id.west_btn);
        healthyBtn= view.findViewById(R.id.health_btn);
        entreesBtn= view.findViewById(R.id.entrees_btn);


        eastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity().getApplicationContext(),MealName.class);
                intent.putExtra("categoryName","شرقي");
                intent.putExtra("categoryId",1);
                startActivity(intent);

            }
        });
        westBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getActivity().getApplicationContext(),MealName.class);
                intent.putExtra("categoryName","غربي");
                intent.putExtra("categoryId",2);
                startActivity(intent);
            }
        });
        healthyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getActivity().getApplicationContext(),MealName.class);
                intent.putExtra("categoryName","صحي");
                intent.putExtra("categoryId",3);
                startActivity(intent);
            }
        });
        entreesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getActivity().getApplicationContext(),MealName.class);
                intent.putExtra("categoryName","مقبلات");
                intent.putExtra("categoryId",4);
                startActivity(intent);
            }
        });

        return view;

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("الوجبات");

    }
}
