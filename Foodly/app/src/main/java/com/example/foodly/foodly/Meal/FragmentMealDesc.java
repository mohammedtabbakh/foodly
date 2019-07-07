package com.example.foodly.foodly.Meal;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.foodly.foodly.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentMealDesc extends Fragment {

    String mealDescritpion;
    TextView mealDescription;
    public FragmentMealDesc(String mealDescritpion) {
        this.mealDescritpion = mealDescritpion;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_meal_desc, container, false);
   mealDescription=view.findViewById(R.id.mealDescription);
   mealDescription.setMovementMethod(new ScrollingMovementMethod());
        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("تفاصيل الوجبة");
        mealDescription=view.findViewById(R.id.mealDescription);
        mealDescription.setText(mealDescritpion);
    }
}
