package me.auri.nutrients;

import java.util.List;

public class NutrientsResponse {

    private int calories;
    private List<HealthLabel> healthLabels;

    private List<Nutrient> nutrients;

    public NutrientsResponse(int calories, List<HealthLabel> healthLabels, List<Nutrient> nutrients) {
        this.calories = calories;
        this.healthLabels = healthLabels;
        this.nutrients = nutrients;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public List<HealthLabel> getHealthLabels() {
        return healthLabels;
    }

    public void setHealthLabels(List<HealthLabel> healthLabels) {
        this.healthLabels = healthLabels;
    }

    public List<Nutrient> getNutrients() {
        return nutrients;
    }

    public void setNutrients(List<Nutrient> nutrients) {
        this.nutrients = nutrients;
    }

    public static enum HealthLabel {
        VEGAN("Vegano"),
        VEGETARIAN("Vegetariano"),
        DAIRY_FREE("Sin lactosa"),
        GLUTEN_FREE("Sin gluten"),
        NO_SUGAR_ADDED("Sin azúcares añadidos");

        private String label;

        HealthLabel(String label) {
            this.label = label;
        }
    }
}
