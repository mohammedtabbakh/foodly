package com.example.foodly.foodly.Order;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import com.example.foodly.foodly.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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

       View view=inflater.inflate(R.layout.order, container, false);
       buyingButton=view.findViewById(R.id.buyBtn);

      /* buyingButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());

               alertDialogBuilder.setTitle("تأكيد الشراء");

               alertDialogBuilder
                       .setMessage("هل تريد تأكيد عملية الشراء")
                       .setCancelable(false)
                       .setPositiveButton("نعم",new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog,int id) {
                             dialog.dismiss();
                               Toast toast = Toast.makeText(getActivity(), "صحتين و هنا سلفاً D:", Toast.LENGTH_SHORT);
                               toast.setGravity(Gravity.CENTER, 0, 0);
                               toast.show();
                           }
                       })
                       .setNegativeButton("لا",new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog, int id) {
                               dialog.cancel();
                           }
                       });
               AlertDialog alertDialog = alertDialogBuilder.create();
               alertDialog.show();
           }
       });*/
       return view;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
for (int i=0;i<OrderCompnents.Ingredeints.size();i++)
{
    items.add(new CartItem(OrderCompnents.Ingredeints.get(i).getIngredientName()));
}

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
        for (int i=0;i<OrderCompnents.Ingredeints.size();i++)
        {
            items.add(new CartItem(OrderCompnents.Ingredeints.get(i).getIngredientName()));
        }
        itemsListView = getView().findViewById(R.id.items_list_view);
        itemsAdapter = new CartItemsAdapter(getContext(), items);
        itemsListView.setAdapter(itemsAdapter);
        buyingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBuyingButtonClicked();
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());

                        alertDialogBuilder.setTitle("تأكيد الشراء");

                        alertDialogBuilder
                                .setMessage("هل تريد تأكيد عملية الشراء")
                                .setCancelable(false)
                                .setPositiveButton("نعم",new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.dismiss();
                                        Toast toast = Toast.makeText(getActivity(), "صحتين و هنا سلفاً D:", Toast.LENGTH_SHORT);

                                        toast.show();
                                    }
                                })
                                .setNegativeButton("لا",new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();

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
