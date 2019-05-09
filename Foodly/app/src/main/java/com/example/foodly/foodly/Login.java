package com.example.foodly.foodly;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.foodly.foodly.Meal.Meal;
import com.example.foodly.foodly.Meal.MealDetail;
import com.example.foodly.foodly.Meal.MealName;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button next = (Button) findViewById(R.id.btnSignup);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), SignUp.class);
                startActivityForResult(myIntent, 0);
            }

        });

        Button next1 = (Button) findViewById(R.id.btnLogin);
        next1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent1 = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(myIntent1, 0);
            }

        });

    }
}
