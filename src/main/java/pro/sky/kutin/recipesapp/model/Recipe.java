package pro.sky.kutin.recipesapp.model;

import java.util.List;

public class Recipe {
    private String title;
    private int cookingTime;
    private List<Ingredient> ingredients;
    private List<String> cookingInstructions;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getCookingInstructions() {
        return cookingInstructions;
    }

    public void setCookingInstructions(List<String> cookingInstructions) {
        this.cookingInstructions = cookingInstructions;
    }
}
