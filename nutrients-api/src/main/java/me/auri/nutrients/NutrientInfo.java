package me.auri.nutrients;

import java.util.List;

public record NutrientInfo(int calories, List<Nutrient> nutrients, List<NutrientsResponse.HealthLabel> healthLabels) {}
