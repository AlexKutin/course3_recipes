package pro.sky.kutin.recipesapp.dto;

import pro.sky.kutin.recipesapp.model.Ingredient;
import pro.sky.kutin.recipesapp.model.Recipe;

import java.util.List;

public class RecipeDTO {
    private final int id;
    private final String title;
    private final int cookingTime;
    private final List<Ingredient> ingredients;
    private final List<String> cookingInstructions;

    public RecipeDTO(int id, String title, int cookingTime, List<Ingredient> ingredients, List<String> cookingInstructions) {
        this.id = id;
        this.title = title;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
        this.cookingInstructions = cookingInstructions;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<String> getCookingInstructions() {
        return cookingInstructions;
    }

    public static RecipeDTO from(int id, Recipe recipe) {
        return new RecipeDTO(
                id,
                recipe.getTitle(),
                recipe.getCookingTime(),
                recipe.getIngredients(),
                recipe.getCookingInstructions()
        );
    }
}
