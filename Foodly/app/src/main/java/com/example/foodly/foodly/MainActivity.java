package com.example.foodly.foodly;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;


import com.example.foodly.foodly.Account.Account;
import com.example.foodly.foodly.Home.Home;
import com.example.foodly.foodly.Meal.Meal;
import com.example.foodly.foodly.MealSuggest.MealSuggest;
import com.example.foodly.foodly.Order.Order;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private TabLayout tab_layout;

    Home home= new Home();
    Meal meal=new Meal();
    Account account=new Account();
    Order order=new Order();
    MealSuggest mealSuggest=new MealSuggest();
    Fragment fragment = home;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame1,fragment).commit();
//         getActionBar().setDisplayOptions(android.app.ActionBar.DISPLAY_SHOW_CUSTOM);
        centerTitle();
    }

    private void initComponent() {

        tab_layout = findViewById(R.id.tab_layout1);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_home).setText(R.string.home), 0);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_search).setText(R.string.meal), 1);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_add_box).setText(R.string.mealsuggest), 2);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_favorite_border).setText(R.string.order), 3);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_person).setText(R.string.account), 4);



        tab_layout.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.color_selected), PorterDuff.Mode.SRC_IN);
        tab_layout.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_IN);
        tab_layout.getTabAt(2).getIcon().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_IN);
        tab_layout.getTabAt(3).getIcon().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_IN);
        tab_layout.getTabAt(4).getIcon().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_IN);

        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override

            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.color_selected), PorterDuff.Mode.SRC_IN);
                switch (tab.getPosition()) {
                    case 0:
                        fragment = home;

                        break;
                    case 1:
                        fragment = meal;
                        break;
                    case 2:
                        fragment = mealSuggest;
                        break;
                    case 3:
                        fragment= order;
                        break;
                    case 4:
                        fragment=account;
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame1,fragment).commit();
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
    private void centerTitle() {
        ArrayList<View> textViews = new ArrayList<>();

        getWindow().getDecorView().findViewsWithText(textViews, getTitle(), View.FIND_VIEWS_WITH_TEXT);

        if(textViews.size() > 0) {
            AppCompatTextView appCompatTextView = null;
            if(textViews.size() == 1) {
                appCompatTextView = (AppCompatTextView) textViews.get(0);
            } else {
                for(View v : textViews) {
                    if(v.getParent() instanceof Toolbar) {
                        appCompatTextView = (AppCompatTextView) v;
                        break;
                    }
                }
            }

            if(appCompatTextView != null) {
                ViewGroup.LayoutParams params = appCompatTextView.getLayoutParams();
                params.width = ViewGroup.LayoutParams.MATCH_PARENT;
                appCompatTextView.setLayoutParams(params);
                appCompatTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }
        }
    }


}