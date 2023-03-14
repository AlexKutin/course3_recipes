package pro.sky.kutin.recipesapp.services;

import pro.sky.kutin.recipesapp.dto.IngredientDTO;
import pro.sky.kutin.recipesapp.model.Ingredient;

import java.util.List;

public interface IngredientService {

    IngredientDTO addIngredient(Ingredient ingredient);

    IngredientDTO getIngredient(int id);

    List<IngredientDTO> getAllIngredients();

    IngredientDTO editIngredient(int id, Ingredient newIngredient);

    boolean deleteIngredient(int id);
}
