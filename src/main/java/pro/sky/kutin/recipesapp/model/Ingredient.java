package pro.sky.kutin.recipesapp.model;

public class Ingredient {
    private String name;
    private float count;
    private String measureUnit;

    public Ingredient(String name, float count, String measureUnit) {
        this.name = name;
        this.count = count;
        this.measureUnit = measureUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }
}
