package Models;

public class CartItem {
    private double ItemCount;
    private int Item;
    private String itemName;


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
}
