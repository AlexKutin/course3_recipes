package pro.sky.kutin.recipesapp.services;

import pro.sky.kutin.recipesapp.dto.RecipeDTO;
import pro.sky.kutin.recipesapp.model.Recipe;

import java.util.List;

public interface RecipeService {

    RecipeDTO addRecipe(Recipe recipe);

    RecipeDTO getRecipe(int id);

    List<RecipeDTO> getRecipesByIngredientId(int ingredientId);

    List<RecipeDTO> getRecipesByIngredientsIds(List<Integer> ingredientsIds);

    List<RecipeDTO> getAllRecipes();

    RecipeDTO editRecipe(int id, Recipe newRecipe);

    boolean deleteRecipe(int id);
}
