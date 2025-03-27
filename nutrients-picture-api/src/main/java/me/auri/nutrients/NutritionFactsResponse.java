package me.auri.nutrients;

import java.util.List;

public class NutritionFactsResponse {

    private int totalCalories;
    private List<String> healthLabels;

    private List<Nutrient> nutrients;

    private String picture;

    public NutritionFactsResponse(int calories, List<String> healthLabels, List<Nutrient> nutrients, String picture) {
        this.totalCalories = calories;
        this.healthLabels = healthLabels;
        this.nutrients = nutrients;
        this.picture = picture;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
