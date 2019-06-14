package Models;

public class MealIngredient {
    private int id;
    private int quantity;
    private int isSelected;
    private int ingredientId;
    private String ingredientName;
    private double price;
    public MealIngredient(String ingredientName,int isSelected) {
        this.ingredientName = ingredientName;
        this.isSelected=isSelected;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public double getPrice() {
        return price;
    }

    public int getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(int isSelected) {
        this.isSelected = isSelected;
    }
}
