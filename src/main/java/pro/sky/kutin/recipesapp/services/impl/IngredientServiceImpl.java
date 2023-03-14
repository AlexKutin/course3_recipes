package pro.sky.kutin.recipesapp.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.kutin.recipesapp.dto.IngredientDTO;
import pro.sky.kutin.recipesapp.model.Ingredient;
import pro.sky.kutin.recipesapp.services.IngredientService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        } /*else {
            throw new IllegalArgumentException("The specified id value was not found in the list");
        }*/
        return null;
    }

    @Override
    public List<IngredientDTO> getAllIngredients() {
        List<IngredientDTO> ingredientDTOList = new ArrayList<>();
        for (Map.Entry<Integer, Ingredient> entry : ingredients.entrySet()) {
            ingredientDTOList.add(IngredientDTO.from(entry.getKey(), entry.getValue()));
        }
        return ingredientDTOList;
    }

    @Override
    public IngredientDTO editIngredient(int id, Ingredient newIngredient) {
        if (ingredients.containsKey(id)) {
            ingredients.put(id, newIngredient);
            return IngredientDTO.from(id, newIngredient);
        }
        return null;
    }

    @Override
    public boolean deleteIngredient(int id) {
        Ingredient ingredient = ingredients.remove(id);
        return ingredient != null;
    }
}
