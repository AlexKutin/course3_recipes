package pro.sky.kutin.recipesapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.kutin.recipesapp.dto.RecipeDTO;
import pro.sky.kutin.recipesapp.model.Recipe;
import pro.sky.kutin.recipesapp.services.RecipeService;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private static final long PAGE_SIZE = 10;
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable("id") int id) {
        RecipeDTO recipeDTO = recipeService.getRecipe(id);
        if (recipeDTO != null) {
            return ResponseEntity.ok(recipeDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<RecipeDTO>> getAllRecipes() {
        List<RecipeDTO> recipeDTOList = recipeService.getAllRecipes();
        return ResponseEntity.ok(recipeDTOList);
    }

    @GetMapping("/byIngredient")
    public ResponseEntity<List<RecipeDTO>> getRecipesByIngredientId(@RequestParam("ingredientId") int ingredientId) {
        List<RecipeDTO> recipesDTO = recipeService.getRecipesByIngredientId(ingredientId);
        if (recipesDTO != null) {
            return ResponseEntity.ok(recipesDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/byIngredients")
    public ResponseEntity<List<RecipeDTO>> getRecipesByIngredientsIds(@RequestParam("ingredientIds") List<Integer> ingredientIds) {
        List<RecipeDTO> recipesDTO = recipeService.getRecipesByIngredientsIds(ingredientIds);
        if (recipesDTO != null) {
            return ResponseEntity.ok(recipesDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/byPage")
    public ResponseEntity<List<RecipeDTO>> getAllRecipesByPage(@RequestParam("page") int pageNumber) {
        // We believe that the page numbering starts from 1
        List<RecipeDTO> recipesDTO = recipeService.getAllRecipes()
                .stream()
                .skip(PAGE_SIZE * (pageNumber - 1))
                .limit(PAGE_SIZE)
                .toList();
        return ResponseEntity.ok(recipesDTO);
    }

    @PostMapping
    public ResponseEntity<RecipeDTO> addRecipe(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.addRecipe(recipe));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeDTO> editRecipeById(@PathVariable("id") int id, @RequestBody Recipe recipe) {
        RecipeDTO recipeDTO = recipeService.editRecipe(id, recipe);
        if (recipeDTO != null) {
            return ResponseEntity.ok(recipeDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipeById(@PathVariable("id") int id) {
        if (recipeService.deleteRecipe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
