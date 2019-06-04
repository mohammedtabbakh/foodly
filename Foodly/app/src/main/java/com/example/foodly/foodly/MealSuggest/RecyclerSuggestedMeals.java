package com.example.foodly.foodly.MealSuggest;

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
import com.example.foodly.foodly.Meal.adapter.models.MealData;
import com.example.foodly.foodly.Meal.MealDetail;
import com.example.foodly.foodly.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerSuggestedMeals extends RecyclerView.Adapter<SuggestedViewHolder> {

    private List<MealData> mMealList;
    private Context mContext;

    public RecyclerSuggestedMeals(List<MealData> mMealList, Context mContext) {
        this.mMealList = mMealList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public SuggestedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredient_recycler_view, parent, false);
        return new SuggestedViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final SuggestedViewHolder holder, int position) {
        Glide.with(holder.mImage.getContext())
                .load(mMealList.get(position).getMealImage())
                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                .into(holder.mImage);
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
class SuggestedViewHolder extends RecyclerView.ViewHolder {

    ImageView mImage;
    TextView mTitle;
    CardView mCardView;


    public SuggestedViewHolder(View itemView) {
        super(itemView);
        mImage = itemView.findViewById(R.id.meal_image);
        mTitle = itemView.findViewById(R.id.meal_title);
        mCardView = itemView.findViewById(R.id.cardview);


    }
}