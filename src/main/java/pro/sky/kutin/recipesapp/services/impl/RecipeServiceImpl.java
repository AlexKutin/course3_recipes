package pro.sky.kutin.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.kutin.recipesapp.dto.RecipeDTO;
import pro.sky.kutin.recipesapp.model.Recipe;
import pro.sky.kutin.recipesapp.services.RecipeService;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static final Map<Integer, Recipe> recipes = new HashMap<>();
    private static int recipeId = 0;

    @Override
    public RecipeDTO addRecipe(Recipe recipe) {
        if (recipe == null) {
            throw new IllegalArgumentException("The recipe value must not be null");
        }
        int id = recipeId++;
        recipes.put(id, recipe);
        return RecipeDTO.from(id, recipe);
    }

    public RecipeDTO getRecipe(int id) {
        Recipe recipe = recipes.get(id);
        if (recipe != null) {
            return RecipeDTO.from(id, recipe);
        } else {
            throw new IllegalArgumentException("The specified id value was not found in the list");
        }
    }
}
