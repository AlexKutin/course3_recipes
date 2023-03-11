package pro.sky.kutin.recipesapp.services;

import pro.sky.kutin.recipesapp.dto.RecipeDTO;
import pro.sky.kutin.recipesapp.model.Recipe;

public interface RecipeService {

    RecipeDTO addRecipe(Recipe recipe);

    RecipeDTO getRecipe(int id);
}
