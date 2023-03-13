package pro.sky.kutin.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.kutin.recipesapp.dto.IngredientDTO;
import pro.sky.kutin.recipesapp.dto.RecipeDTO;
import pro.sky.kutin.recipesapp.model.Ingredient;
import pro.sky.kutin.recipesapp.model.Recipe;
import pro.sky.kutin.recipesapp.services.IngredientService;
import pro.sky.kutin.recipesapp.services.RecipeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static final Map<Integer, Recipe> recipes = new HashMap<>();
    private static int recipeId = 0;
    private final IngredientService ingredientService;

    public RecipeServiceImpl(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

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
        } /*else {
            throw new IllegalArgumentException("The specified id value was not found in the list");
        }*/
        return null;
    }

    @Override
    public List<RecipeDTO> getRecipesByIngredientId(int ingredientId) {
        IngredientDTO ingredientDTO = ingredientService.getIngredient(ingredientId);
        if (ingredientDTO == null) {
            return null;
        }
        String ingredientName = ingredientDTO.getName();

        return recipes.entrySet()
                .stream()
                .filter(entry -> entry.getValue()
                        .getIngredients()
                        .stream()
                        .anyMatch(ingredient -> ingredient.getName().equals(ingredientName)))
                .map(filteredEntry -> RecipeDTO.from(filteredEntry.getKey(), filteredEntry.getValue()))
                .toList();
    }

    @Override
    public List<RecipeDTO> getRecipesByIngredientsIds(List<Integer> ingredientsIds) {
        List<String> ingredientsNames = ingredientService.getAllIngredients()
                .stream()
                .filter(ingredientDTO -> ingredientsIds.contains(ingredientDTO.getId()))
                .map(IngredientDTO::getName)
                .toList();

        return recipes.entrySet()
                .stream()
                .filter(entry -> entry.getValue()
                        .getIngredients()
                        .stream().map(Ingredient::getName).toList().containsAll(ingredientsNames))
                .map(filteredEntry -> RecipeDTO.from(filteredEntry.getKey(), filteredEntry.getValue()))
                .toList();
    }

    @Override
    public List<RecipeDTO> getAllRecipes() {
        List<RecipeDTO> recipeDTOList = new ArrayList<>();
        for (Map.Entry<Integer, Recipe> recipeEntry : recipes.entrySet()) {
            recipeDTOList.add(RecipeDTO.from(recipeEntry.getKey(), recipeEntry.getValue()));
        }
        return recipeDTOList;
    }

    @Override
    public RecipeDTO editRecipe(int id, Recipe newRecipe) {
        if (recipes.containsKey(id)) {
            if (newRecipe == null) {
                throw new IllegalArgumentException("The recipe value must not be null");
            }
            recipes.put(id, newRecipe);
            return RecipeDTO.from(id, newRecipe);
        }
        return null;
    }

    @Override
    public boolean deleteRecipe(int id) {
        Recipe deletedRecipe = recipes.remove(id);
        return deletedRecipe != null;
    }
}
