package com.example.foodly.foodly.Meal;


import com.example.foodly.foodly.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;


import androidx.appcompat.app.AppCompatActivity;


import androidx.fragment.app.Fragment;


import android.os.Bundle;


import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MealDetail extends AppCompatActivity {

   FragmentMealDetail MealDetail=new FragmentMealDetail();
    FragmentMealDesc MealDesc=new FragmentMealDesc();
    ImageView mMeal;
    TextView mMealTitle;
    TabLayout tabLayout;
    Fragment fragment1= MealDetail;
    private static int cart_count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_detail);


        mMeal = findViewById(R.id.meal_image);
        mMealTitle = findViewById(R.id.meal_title);


//        Bundle mBundle = getIntent().getExtras();
//        if (mBundle != null) {
//            mMealTitle.setText(mBundle.getString("Title"));
//            mMeal.setImageResource(mBundle.getInt("Image"));
//
//        }
        initComponent();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame2,fragment1).commit();

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
                        fragment1 = MealDetail;
                        break;
                    case 1:
                        fragment1 = MealDesc;
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame2,fragment1).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_meal_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        int id = item.getItemId();
                return super.onOptionsItemSelected(item);

    }


    public void onAddProduct() {
        cart_count++;
        invalidateOptionsMenu();
        Snackbar.make(findViewById(R.id.main_content), "Added to cart !!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();


    }


    public void onRemoveProduct() {
        cart_count--;
        invalidateOptionsMenu();
        Snackbar.make(findViewById(R.id.main_content), "Removed from cart !!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

    }


}
