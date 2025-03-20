package me.auri.nutrients;

import java.util.List;

public record NutritionalInfo(String ingredient, int calories, List<Nutrient> nutrients, List<NutrionFactsResponse.HealthLabel> healthLabels) {}
