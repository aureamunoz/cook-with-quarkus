package me.auri.nutrients;

import java.util.List;

public record NutritionalFacts(String ingredient, int calories, List<Nutrient> nutrients, List<NutriPicResponse.HealthLabel> healthLabels) {}
