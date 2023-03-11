package pro.sky.kutin.recipesapp.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.kutin.recipesapp.dto.RecipeDTO;
import pro.sky.kutin.recipesapp.model.Recipe;
import pro.sky.kutin.recipesapp.services.RecipeService;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}")
    public RecipeDTO getRecipe(@PathVariable("id") int id) {
        return recipeService.getRecipe(id);
    }

    @PostMapping
    public RecipeDTO addRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }
}
