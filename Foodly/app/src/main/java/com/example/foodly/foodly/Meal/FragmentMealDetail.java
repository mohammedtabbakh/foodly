package com.example.foodly.foodly.Meal;



import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodly.foodly.Meal.adapter.MealDetailAdapter;
import com.example.foodly.foodly.Meal.models.MealIngrData;
import com.example.foodly.foodly.R;
import com.robertlevonyan.views.customfloatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentMealDetail extends Fragment  {

    RecyclerView IngrRecyclerView;
    List<MealIngrData> MealIngrList;
    MealIngrData mMealIngrData;
    FloatingActionButton fab;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_meal_detail, container, false);

        IngrRecyclerView = view.findViewById(R.id.ingr_recycler);
        fab = view.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Toast  toast= Toast.makeText(getActivity(),"صحتين و هنا سلفاً D:",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER ,0,0);
            toast.show();

            }
        });

        IngrRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(view.getContext());
       IngrRecyclerView.setLayoutManager(layoutManager);

       MealIngrList=new ArrayList<>();

       mMealIngrData = new MealIngrData("بندورة",R.id.ingr_selector);
       MealIngrList.add(mMealIngrData);

        mMealIngrData = new MealIngrData("كوسا",R.id.ingr_selector);
        MealIngrList.add(mMealIngrData);
        mMealIngrData = new MealIngrData("بهارات",R.id.ingr_selector);
        MealIngrList.add(mMealIngrData);
        mMealIngrData = new MealIngrData("زيت",R.id.ingr_selector);
        MealIngrList.add(mMealIngrData);
        mMealIngrData = new MealIngrData("ملح",R.id.ingr_selector);
        MealIngrList.add(mMealIngrData);
        mMealIngrData = new MealIngrData("خيار",R.id.ingr_selector);
        MealIngrList.add(mMealIngrData);


       MealDetailAdapter ingrRecycler = new MealDetailAdapter(view.getContext(),MealIngrList);
        IngrRecyclerView.setAdapter(ingrRecycler);

        return view;


    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("المكونات");

    }
}
