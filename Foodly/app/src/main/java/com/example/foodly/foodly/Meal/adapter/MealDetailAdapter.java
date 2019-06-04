package com.example.foodly.foodly.Meal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodly.foodly.Meal.adapter.models.MealIngrData;
import com.example.foodly.foodly.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MealDetailAdapter extends RecyclerView.Adapter<MealDetailViewHolder> {

    private Context context;

    private List<MealIngrData> MealIngrList;
    int count=0;

    public MealDetailAdapter(Context context, List<MealIngrData> MealIngrList) {
        this.context = context;
        this.MealIngrList = MealIngrList;
    }

    @NonNull
    @Override
    public MealDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredient_recycler_view, parent, false);
        return new MealDetailViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MealDetailViewHolder holder, int position) {
        holder.ingrName.setText(MealIngrList.get(position).getMealingrName());
//        Glide.with(holder.ingrSelector.getContext())
//                .load(MealIngrList.get(position).getMealSelected())
//                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE))
//                .into(holder.ingrSelector);
        holder.cardViewIngr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                holder.ingrSelector.setImageResource(R.drawable.image_not_selected);

                if(!v.isSelected()) {

                    v.setSelected(true);
                }
                else if(v.isSelected())
                {

                    v.setSelected(false);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return MealIngrList.size();
    }
}
class MealDetailViewHolder extends RecyclerView.ViewHolder{

    TextView ingrName;
    ImageView ingrSelector;
    CardView cardViewIngr;
    public MealDetailViewHolder(@NonNull View itemView) {
        super(itemView);
        ingrName=itemView.findViewById(R.id.ingr_name);
        ingrSelector=itemView.findViewById(R.id.ingr_selector);
        cardViewIngr=itemView.findViewById(R.id.cardview_ingr);

    }
}
