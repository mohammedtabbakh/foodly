package com.example.foodly.foodly.Meal.adapter;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodly.foodly.Meal.MealDetail;
import com.example.foodly.foodly.R;
import java.util.List;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<MealViewHolder> {

    private Context mContext;
    private List<Models.Meal>  MealsList;



    public RecyclerAdapter(Context mContext, List<Models.Meal> mealsList) {
        this.mContext = mContext;
        this.MealsList = mealsList;
    }


    @Override
    public MealViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row_item, parent, false);
        return new MealViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final MealViewHolder holder, final int position) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);
//          Uri photoUri = Uri.fromFile(new File(MealsList.get(position).getPhoto()));

        Glide.with(mContext)
                .load(MealsList.get(position).getPhoto())
                .apply(options)
                .into(holder.mImage);
    // holder.mImage.setImageResource(mMealList.get(position).getMealImage());
       holder.mTitle.setText(MealsList.get(position).getName());
       holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, MealDetail.class);
                mIntent.putExtra("Title", MealsList.get(holder.getAdapterPosition()).getName());
                mIntent.putExtra("Image", MealsList.get(holder.getAdapterPosition()).getPhoto());
                mIntent.putExtra("id",MealsList.get(position).getId());
                mIntent.putExtra("description",MealsList.get(position).getDescription());
                mContext.startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return MealsList.size();
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
