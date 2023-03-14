package pro.sky.kutin.recipesapp.dto;

import pro.sky.kutin.recipesapp.model.Ingredient;

public class IngredientDTO {
    private final int id;
    private final String name;
    private final float count;
    private final String measureUnit;

    public IngredientDTO(int id, String name, float count, String measureUnit) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.measureUnit = measureUnit;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getCount() {
        return count;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public static IngredientDTO from(int id, Ingredient ingredient) {
        return new IngredientDTO(id, ingredient.getName(), ingredient.getCount(), ingredient.getMeasureUnit());
    }
}
