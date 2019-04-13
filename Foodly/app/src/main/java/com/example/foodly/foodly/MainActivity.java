package com.example.foodly.foodly;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import android.graphics.PorterDuff;
import android.os.Bundle;


import com.example.foodly.foodly.Account.Account;
import com.example.foodly.foodly.Home.Home;
import com.example.foodly.foodly.Meal.Meal;
import com.example.foodly.foodly.MealSuggest.MealSuggest;
import com.example.foodly.foodly.Order.Order;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    private TabLayout tab_layout;
    private ActionBar actionBar;
    private NestedScrollView nested_scroll_view;
    Home home= new Home();
    Meal meal=new Meal();
    Account acount=new Account();
    Order order=new Order();
    MealSuggest mealSuggest=new MealSuggest();
    Fragment fragment = home;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();

    }

    private void initComponent() {

        tab_layout = findViewById(R.id.tab_layout);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_home), 0);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_search), 1);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_add_box), 2);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_favorite_border), 3);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_person), 4);



        tab_layout.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
        tab_layout.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_IN);
        tab_layout.getTabAt(2).getIcon().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_IN);
        tab_layout.getTabAt(3).getIcon().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_IN);
        tab_layout.getTabAt(4).getIcon().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_IN);

        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override

            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.deep_orange_500), PorterDuff.Mode.SRC_IN);
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
                        fragment=acount;
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
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
}