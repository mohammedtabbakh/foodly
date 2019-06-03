package com.example.foodly.foodly.MealSuggest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodly.foodly.Meal.MealName;
import com.example.foodly.foodly.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MealSuggest extends Fragment {

    RecyclerView mRecyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.meal_suggest, container, false);


        mRecyclerView = view.findViewById(R.id.suggest_recycler);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(view.getContext(), 3);
        mRecyclerView.setLayoutManager(mGridLayoutManager);




        return view;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("الوجبات المقترحة");
    }
}
