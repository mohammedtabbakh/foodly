package com.example.foodly.foodly.Meal.adapter;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodly.foodly.Meal.MealData;
import com.example.foodly.foodly.Meal.MealDetail;
import com.example.foodly.foodly.R;

import java.util.List;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<MealViewHolder> {

    private Context mContext;
    private List<MealData> mMealList;



    public RecyclerAdapter(Context mContext, List<MealData> mMealList) {
        this.mContext = mContext;
        this.mMealList = mMealList;
    }


    @Override
    public MealViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row_item, parent, false);
        return new MealViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final MealViewHolder holder, int position) {

        Glide.with(holder.mImage.getContext())
                .load(mMealList.get(position).getMealImage())
                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                .into(holder.mImage);
    // holder.mImage.setImageResource(mMealList.get(position).getMealImage());
       holder.mTitle.setText(mMealList.get(position).getMealName());
       holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, MealDetail.class);
                mIntent.putExtra("Title", mMealList.get(holder.getAdapterPosition()).getMealName());
                mIntent.putExtra("Image", mMealList.get(holder.getAdapterPosition()).getMealImage());
                mContext.startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMealList.size();
    }
}
class MealViewHolder extends RecyclerView.ViewHolder {

    ImageView mImage;
    TextView mTitle;
    CardView mCardView;


    MealViewHolder(View itemView) {
        super(itemView);
        mImage = itemView.findViewById(R.id.meal_image);
        mTitle = itemView.findViewById(R.id.meal_title);
        mCardView = itemView.findViewById(R.id.cardview);


    }
}
