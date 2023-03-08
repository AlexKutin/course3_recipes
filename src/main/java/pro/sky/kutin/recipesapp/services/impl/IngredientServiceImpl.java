package pro.sky.kutin.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.kutin.recipesapp.dto.IngredientDTO;
import pro.sky.kutin.recipesapp.model.Ingredient;
import pro.sky.kutin.recipesapp.services.IngredientService;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {
    private static final Map<Integer, Ingredient> ingredients = new HashMap<>();
    private static int ingredientId = 0;

    @Override
    public IngredientDTO addIngredient(Ingredient ingredient) {
        if (ingredient == null) {
            throw new IllegalArgumentException("The ingredient value must not be null");
        }
        int id = ingredientId++;
        ingredients.put(id, ingredient);
        return IngredientDTO.from(id, ingredient);
    }

    @Override
    public IngredientDTO getIngredient(int id) {
        Ingredient ingredient = ingredients.get(id);
        if (ingredient != null) {
            return IngredientDTO.from(id, ingredient);
        } else {
            throw new IllegalArgumentException("The specified id value was not found in the list");
        }
    }
}
