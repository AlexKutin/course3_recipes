package pro.sky.kutin.recipesapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.kutin.recipesapp.dto.IngredientDTO;
import pro.sky.kutin.recipesapp.model.Ingredient;
import pro.sky.kutin.recipesapp.services.IngredientService;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientDTO> getIngredientById(@PathVariable("id") int id) {
        IngredientDTO ingredientDTO = ingredientService.getIngredient(id);
        if (ingredientDTO != null) {
            return ResponseEntity.ok(ingredientDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<IngredientDTO>> getAllIngredients() {
        List<IngredientDTO> ingredients = ingredientService.getAllIngredients();
        return ResponseEntity.ok(ingredients);
    }

    @PostMapping
    public ResponseEntity<IngredientDTO> addIngredient(@RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientService.addIngredient(ingredient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngredientDTO> editIngredientById(@PathVariable("id") int id, @RequestBody Ingredient ingredient) {
        IngredientDTO ingredientDTO = ingredientService.editIngredient(id, ingredient);
        if (ingredientDTO != null) {
            return ResponseEntity.ok(ingredientDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredientById(@PathVariable("id") int id) {
        if (ingredientService.deleteIngredient(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
