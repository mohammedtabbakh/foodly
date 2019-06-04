package com.example.foodly.foodly.Order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;


import com.example.foodly.foodly.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import com.example.foodly.foodly.Order.Models.CartItem;

public class Order extends Fragment {

    ListView itemsListView;
    CartItemsAdapter itemsAdapter;
    ArrayList<CartItem> items;
    Button buyingButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.order, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buyingButton = getView().findViewById(R.id.addButton);

        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("الطلبات");
        items = new ArrayList<CartItem>();
        items.add(new CartItem() {{
            setItemName("فول");
        }});
        items.add(new CartItem() {{
            setItemName("حمص");
        }});
        items.add(new CartItem() {{
            setItemName("تفاح");
        }});
        items.add(new CartItem() {{
            setItemName("برتقال");
        }});

        itemsListView = getView().findViewById(R.id.items_list_view);
        itemsAdapter = new CartItemsAdapter(getContext(), items);
        itemsListView.setAdapter(itemsAdapter);
        buyingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBuyingButtonClicked();
            }
        });
    }

    private void onBuyingButtonClicked() {
        ArrayList<CartItem> cartlist =new ArrayList<CartItem>() ;
        for (int i =0;i<itemsAdapter.getCount();i++)
        {
            CartItem item =itemsAdapter.getItem(i);
            if (item.isChecked()){
                cartlist.add(item);
            }
        }

    }
}
