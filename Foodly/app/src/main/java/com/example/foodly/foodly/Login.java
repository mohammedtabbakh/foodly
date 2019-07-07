package com.example.foodly.foodly;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final EditText etUser=findViewById(R.id.etUser);
        final EditText etPass=findViewById(R.id.etpass);
        final Button next = findViewById(R.id.btnSignup);

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), SignUp.class);
                startActivityForResult(myIntent, 0);
            }

        });

        final Button next1 = findViewById(R.id.btnLogin);
        next1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
//                if((etUser.getText().toString()=="nizo")  && (etPass.getText().toString()=="nizo"))

                    Intent myIntent1 = new Intent(view.getContext(), MainActivity.class);
                    startActivityForResult(myIntent1, 0);
                
            }

        });

    }
}
