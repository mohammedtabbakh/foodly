package com.example.foodly.foodly.Order;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.foodly.foodly.R;

import java.util.ArrayList;

import com.example.foodly.foodly.Order.Models.CartItem;

public class CartItemsAdapter extends ArrayAdapter<CartItem> {
    public CartItemsAdapter(Context context, ArrayList<CartItem> cartItems) {
        super(context, 0, cartItems);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final CartItem item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cart_item, parent, false);
        }
        // Lookup view for data population
        CheckBox itemName = convertView.findViewById(R.id.item);

        final EditText itemCount = convertView.findViewById(R.id.itemCount);
        itemCount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                item.setItemCount(Double.parseDouble(s.toString()));
            }
        });

        // Populate the data into the template view using the data object
        itemName.setText(item.getItemName());
        itemName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                CartItem item = getItem(position);
                item.setChecked(isChecked);
            }
        });
        // Return the completed view to render on screen
        return convertView;
    }

}
