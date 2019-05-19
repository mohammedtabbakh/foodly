package com.example.foodly.foodly.Order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.foodly.foodly.R;

import java.util.ArrayList;

import Models.CartItem;

public class CartItemsAdapter extends ArrayAdapter<CartItem> {

    public CartItemsAdapter(Context context, ArrayList<CartItem> cartItems) {
        super(context, 0, cartItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        CartItem item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cart_item, parent, false);
        }
        // Lookup view for data population
        CheckBox itemName =   convertView.findViewById(R.id.item);
        NumberPicker itemCount =  convertView.findViewById(R.id.itemCount);
        // Populate the data into the template view using the data object
        itemName.setText(item.getItemName());
        // Return the completed view to render on screen
        return convertView;
    }

}
