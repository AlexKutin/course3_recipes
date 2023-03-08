package pro.sky.kutin.recipesapp.services;

import pro.sky.kutin.recipesapp.dto.IngredientDTO;
import pro.sky.kutin.recipesapp.model.Ingredient;

public interface IngredientService {

    IngredientDTO addIngredient(Ingredient ingredient);

    IngredientDTO getIngredient(int id);
}
