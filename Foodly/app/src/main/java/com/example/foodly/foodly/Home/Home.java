package com.example.foodly.foodly.Home;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodly.foodly.Meal.adapter.RecyclerAdapter;
import com.example.foodly.foodly.Meal.models.MealData;
import com.example.foodly.foodly.R;

import java.util.ArrayList;
import java.util.List;


public class Home extends Fragment {

    private RecyclerView SuggestHomeRecyclerView;
    private RecyclerView MostDemandRecyclerView;
    private MealData mealData;
    private List<MealData> SuggestHomeList;
    private List<MealData> MostDemandList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
       View view = inflater.inflate(R.layout.home, container, false);

       SuggestHomeRecyclerView=view.findViewById(R.id.suggested_home_recycler);
       MostDemandRecyclerView=view.findViewById(R.id.most_Demand_recycler);

        GridLayoutManager GridLayoutManager1 = new GridLayoutManager(view.getContext(), 3);
        SuggestHomeRecyclerView.setLayoutManager(GridLayoutManager1);

        GridLayoutManager mGridLayoutManager2 = new GridLayoutManager(view.getContext(), 3);
        MostDemandRecyclerView.setLayoutManager(mGridLayoutManager2);

       MostDemandList=new ArrayList<>();

        mealData = new MealData("يبرق",
                R.drawable.yabraq);
        MostDemandList.add(mealData);

        mealData = new MealData("فريكة",
                R.drawable.frike);
        MostDemandList.add(mealData);

        mealData = new MealData("يبرق",
                R.drawable.yabraq);
        MostDemandList.add(mealData);





        SuggestHomeList=new ArrayList<>();


        mealData = new MealData("فاصولية بيضاء",
                R.drawable.fasolie);
        SuggestHomeList.add(mealData);

        mealData = new MealData("فريكة",
                R.drawable.frike);
        SuggestHomeList.add(mealData);

        mealData = new MealData("فاصولية بيضاء",
                R.drawable.fasolie);
        SuggestHomeList.add(mealData);



        RecyclerAdapter recyclerAdapter1 = new RecyclerAdapter(view.getContext(),MostDemandList);
        MostDemandRecyclerView.setAdapter(recyclerAdapter1);

        RecyclerAdapter recyclerAdapter2 = new RecyclerAdapter(view.getContext(),SuggestHomeList);
        SuggestHomeRecyclerView.setAdapter(recyclerAdapter2);
       return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("الرئيسية");
    }
}
