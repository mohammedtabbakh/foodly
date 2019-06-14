package com.example.foodly.foodly.Meal;


import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodly.foodly.Api.ApiClient;
import com.example.foodly.foodly.Api.ApiEndPoints;
import com.example.foodly.foodly.Meal.adapter.MealDetailAdapter;
import com.example.foodly.foodly.Meal.adapter.RecyclerAdapter;
import com.example.foodly.foodly.R;
import com.robertlevonyan.views.customfloatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import Models.MealIngredient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentMealDetail extends Fragment {

    RecyclerView IngrRecyclerView;
    MealDetailAdapter ingredientsAdapter;
    MealIngrData mMealIngrData;
    FloatingActionButton fab;
    int mealId;
    List<MealIngredient> mealIngredients;
    public FragmentMealDetail(int mealId) {
        this.mealId = mealId;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_meal_detail, container, false);

        IngrRecyclerView = view.findViewById(R.id.ingr_recycler);
        fab = view.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getActivity(), "صحتين و هنا سلفاً D:", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });

        IngrRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        IngrRecyclerView.setLayoutManager(layoutManager);

        mealIngredients = new ArrayList<>();

        ingredientsAdapter = new MealDetailAdapter(view.getContext(), mealIngredients);
        IngrRecyclerView.setAdapter(ingredientsAdapter);


        ApiEndPoints apiEndPoints = ApiClient.getClient().create(ApiEndPoints.class);
        apiEndPoints.GetMealIngredients(mealId).enqueue(new Callback<List<MealIngredient>>() {
            @Override
            public void onResponse(Call<List<MealIngredient>> call, Response<List<MealIngredient>> response) {
                mealIngredients =response.body();
                ingredientsAdapter = new MealDetailAdapter( getContext(), mealIngredients);
                IngrRecyclerView.setAdapter(ingredientsAdapter);
            }

            @Override
            public void onFailure(Call<List<MealIngredient>> call, Throwable t) {
            Toast.makeText(getActivity(),"حدث خطأ غير متوقع",Toast.LENGTH_SHORT).show();
            }
        });



        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("المكونات");

    }
}
