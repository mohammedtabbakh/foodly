package com.example.foodly.foodly.Account;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.foodly.foodly.Login;
import com.example.foodly.foodly.MainActivity;
import com.example.foodly.foodly.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Account extends Fragment {
    Button logout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.account, container, false);
        logout=view.findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent1 = new Intent(getContext(), Login.class);
                startActivityForResult(myIntent1, 0);
            }
        });

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("الحساب");
    }
}
