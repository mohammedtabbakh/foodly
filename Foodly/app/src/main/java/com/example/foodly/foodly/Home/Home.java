package com.example.foodly.foodly.Home;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodly.foodly.Api.ApiClient;
import com.example.foodly.foodly.Api.ApiEndPoints;
import com.example.foodly.foodly.Meal.MealName;
import com.example.foodly.foodly.Meal.adapter.RecyclerAdapter;
import com.example.foodly.foodly.R;

import java.util.ArrayList;
import java.util.List;

import Models.Meal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Home extends Fragment {

    private RecyclerView SuggestHomeRecyclerView;
    private RecyclerView MostDemandRecyclerView;
    private Meal mealData;
    private List<Meal> SuggestHomeList;
    private List<Meal> MostDemandList;
    List<Models.Meal> MealsList;
    int i;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
      final View view = inflater.inflate(R.layout.home, container, false);

       SuggestHomeRecyclerView=view.findViewById(R.id.suggested_home_recycler);
       MostDemandRecyclerView=view.findViewById(R.id.mostDemandRecycler);


        LinearLayoutManager layoutManager= new LinearLayoutManager(view.getContext(),RecyclerView.HORIZONTAL,false);
        MostDemandRecyclerView.setLayoutManager(layoutManager);


        GridLayoutManager GridLayoutManager1 = new GridLayoutManager(view.getContext(), 3);
        SuggestHomeRecyclerView.setLayoutManager(GridLayoutManager1);

        ApiEndPoints apiEndPoints = ApiClient.getClient().create(ApiEndPoints.class);

        MealsList = new ArrayList<>();


//
//       MostDemandList=new ArrayList<>();
//
//        mealData = new Meal("يبرق");
//        MostDemandList.add(mealData);
//
//        mealData = new Meal("فريكة");
//        MostDemandList.add(mealData);
//
//        mealData = new Meal("يبرق");
//        MostDemandList.add(mealData);
//
//        mealData = new Meal("يبرق");
//        MostDemandList.add(mealData);
//
//        mealData = new Meal("يبرق");
//        MostDemandList.add(mealData);
//
//        mealData = new Meal("يبرق");
//        MostDemandList.add(mealData);
//
//        mealData = new Meal("يبرق");
//        MostDemandList.add(mealData);
//
//
//
//
//
//        SuggestHomeList=new ArrayList<>();
//
//        mealData = new Meal("فاصولية بيضاء");
//        SuggestHomeList.add(mealData);
//
//        mealData = new Meal("فريكة");
//        SuggestHomeList.add(mealData);
//
//        mealData = new Meal("فاصولية بيضاء");
//        SuggestHomeList.add(mealData);
//
//        mealData = new Meal("فاصولية بيضاء");
//        SuggestHomeList.add(mealData);
//
//        mealData = new Meal("فاصولية بيضاء");
//        SuggestHomeList.add(mealData);
//
//        mealData = new Meal("فاصولية بيضاء");
//        SuggestHomeList.add(mealData);


        apiEndPoints.GetAllMeals().enqueue(new Callback<List<Meal>>() {
            @Override
            public void onResponse(Call<List<Meal>> call, Response<List<Meal>> response) {

                MealsList = response.body();
                MostDemandList=new ArrayList<>();
                for( i=0;i<MealsList.size()/2;i++)
                {

                    MostDemandList.add(MealsList.get(i));

                }
                RecyclerAdapter recyclerAdapter1 = new RecyclerAdapter(view.getContext(),MostDemandList);
                MostDemandRecyclerView.setAdapter(recyclerAdapter1);

                SuggestHomeList=new ArrayList<>();
                for( i=MealsList.size()/2;i<MealsList.size();i++)
                {

                   SuggestHomeList.add(MealsList.get(i));
                }

                RecyclerAdapter recyclerAdapter2 = new RecyclerAdapter(view.getContext(),SuggestHomeList);
                SuggestHomeRecyclerView.setAdapter(recyclerAdapter2);
            }

            @Override
            public void onFailure(Call<List<Meal>> call, Throwable t) {
                MealsList.add(new Meal("فريكة"));
                MealsList.add(new Meal("فاصوليا"));
            }
        });


       return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("الرئيسية");
    }
}
