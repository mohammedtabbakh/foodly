package com.example.foodly.foodly.Order.Models;

public class CartItem {
    private double ItemCount;
    private int Item;
    private String itemName;
private boolean IsChecked;

    public double getItemCount() {
        return ItemCount;
    }

    public void setItemCount(double itemCount) {
        ItemCount = itemCount;
    }

    public int getItem() {
        return Item;
    }

    public void setItem(int item) {
        Item = item;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isChecked() {
        return IsChecked;
    }

    public void setChecked(boolean checked) {
        IsChecked = checked;
    }
}
