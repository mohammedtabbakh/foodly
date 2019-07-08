package Models;

import java.util.List;

public class Meal {


    public Meal(String Name) {
        setName(Name);
    }

    private int  id;
    private String name;
    private String description;
    private Category category;
    private int categoryId;
    private double calories;
    private String fullPhotoPath;
    private int preparingTime;
    private List<MealIngredient> mealIngredients;
    public int getId() {
        return  id;
    }


    public String getDescription() {
        return description;
    }


    public Category getCategory() {
        return category;
    }

    public double getCalories() {
        return calories;
    }

    public String getPhoto() {
        return fullPhotoPath;
    }

    public int getPreparingTime() {
        return preparingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MealIngredient> getMealIngredients() {
        return mealIngredients;
    }

    public void setMealIngredients(List<MealIngredient> mealIngredients) {
        this.mealIngredients = mealIngredients;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
