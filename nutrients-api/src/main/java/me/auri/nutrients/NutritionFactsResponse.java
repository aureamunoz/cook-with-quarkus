package me.auri.nutrients;

import java.util.List;

public class NutritionFactsResponse {

    private int totalCalories;
    private List<String> healthLabels;

    private List<Nutrient> nutrients;

    public NutritionFactsResponse(int calories, List<String> healthLabels, List<Nutrient> nutrients) {
        this.totalCalories = calories;
        this.healthLabels = healthLabels;
        this.nutrients = nutrients;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public List<String> getHealthLabels() {
        return healthLabels;
    }

    public void setHealthLabels(List<String> healthLabels) {
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

        public String getLabel() {
            return label;
        }
    }
}
