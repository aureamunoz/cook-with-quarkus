package me.auri.nutrients;

import java.util.List;

public class NutriPicResponse {

    private int totalCalories;
    private String healthLabels;

    private String nutrients;

    private String picture;

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public String getHealthLabels() {
        return healthLabels;
    }

    public void setHealthLabels(String healthLabels) {
        this.healthLabels = healthLabels;
    }

    public String getNutrients() {
        return nutrients;
    }

    public void setNutrients(String nutrients) {
        this.nutrients = nutrients;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public static enum HealthLabel {
        VEGAN("Vegano"), VEGETARIAN("Vegetariano"), DAIRY_FREE("Sin lactosa"), GLUTEN_FREE("Sin gluten"),
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
