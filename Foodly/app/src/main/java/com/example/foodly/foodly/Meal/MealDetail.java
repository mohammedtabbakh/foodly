package com.example.foodly.foodly.Meal;


import com.example.foodly.foodly.R;
import com.google.android.material.tabs.TabLayout;


import androidx.appcompat.app.AppCompatActivity;


import androidx.fragment.app.Fragment;


import android.os.Bundle;


import android.widget.ImageView;


public class MealDetail extends AppCompatActivity {

   FragmentMealDetail MealDetail=new FragmentMealDetail();
    FragmentMealDesc MealDesc=new FragmentMealDesc();
    ImageView mMeal;
    TabLayout tabLayout;
    Fragment fragment= MealDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_detail);
        initComponent();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame2,fragment).commit();
        mMeal = findViewById(R.id.meal_image);


        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {

            mMeal.setImageResource(mBundle.getInt("Image"));

        }

    }
    private void initComponent() {

        tabLayout = findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.mealDetail), 0);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.mealDesc), 1);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        fragment = MealDetail;

                        break;
                    case 1:
                        fragment = MealDesc;
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame2,fragment).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
