package me.auri.nutrients;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ApplicationScoped
public class NutrientRepository {

    private final Map<String, NutritionalInfo> nutrientDatabase = new HashMap<>();

    @PostConstruct
    void init() {
        //Spaghetti Carbonara -> Spaghetti:200g, Huevo:2 unidades, Panceta:100g, Queso parmesano:50g, Pimienta negra:1 pizca
        nutrientDatabase.put("spaghetti", new NutritionalInfo( "spaghetti",742,
                List.of(new Nutrient("Fat", 3, "g"),
                        new Nutrient("Carbohydrates", 149.4, "g"),
                        new Nutrient("Protein", 26, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN)));

        nutrientDatabase.put("huevo", new NutritionalInfo("huevo",123,
                List.of(new Nutrient("Protein", 10.8, "g"),
                        new Nutrient("Carbohydrates", 0.6, "g"),
                        new Nutrient("Fat", 8.2, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED, NutritionFactsResponse.HealthLabel.GLUTEN_FREE, NutritionFactsResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("panceta", new NutritionalInfo("panceta",393,
                List.of(new Nutrient("Protein", 13.7, "g"),
                        new Nutrient("Carbohydrates", 0, "g"),
                        new Nutrient("Fat", 37.1, "g")),
                List.of(NutritionFactsResponse.HealthLabel.GLUTEN_FREE)));

        nutrientDatabase.put("queso parmesano", new NutritionalInfo("queso parmesano",196,
                List.of(new Nutrient("Protein", 17.9, "g"),
                        new Nutrient("Carbohydrates", 1.6, "g"),
                        new Nutrient("Fat", 12.5, "g")),
                List.of(NutritionFactsResponse.HealthLabel.GLUTEN_FREE)));

        nutrientDatabase.put("pimienta negra", new NutritionalInfo("pimienta negra",0,
                List.of(new Nutrient("Protein", 0, "g"),
                        new Nutrient("Carbohydrates", 0, "g"),
                        new Nutrient("Fat", 0, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED, NutritionFactsResponse.HealthLabel.GLUTEN_FREE, NutritionFactsResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("sal", new NutritionalInfo("sal",0,
                List.of(new Nutrient("Sodium", 147.5, "mg")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED, NutritionFactsResponse.HealthLabel.GLUTEN_FREE, NutritionFactsResponse.HealthLabel.DAIRY_FREE)));


        //Pizza Margarita -> Harina:300g, Agua:200ml, Levadura:5g, Tomate:150g, Mozzarella:100g, Albahaca:5 hojas
        nutrientDatabase.put("harina", new NutritionalInfo("harina",1092,
                List.of(new Nutrient("Protein", 30.9, "g"),
                        new Nutrient("Carbohydrates", 228.9, "g"),
                        new Nutrient("Fat", 2.9, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN)));

        nutrientDatabase.put("agua", new NutritionalInfo("agua",0,
                List.of(new Nutrient("Protein", 0, "g"),
                        new Nutrient("Carbohydrates", 0, "g"),
                        new Nutrient("Fat", 0, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED, NutritionFactsResponse.HealthLabel.GLUTEN_FREE, NutritionFactsResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("levadura", new NutritionalInfo("levadura",16,
                List.of(new Nutrient("Protein", 2, "g"),
                        new Nutrient("Carbohydrates", 2.1 , "g"),
                        new Nutrient("Fat", 0.4, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED, NutritionFactsResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("tomate", new NutritionalInfo("tomate",36,
                List.of(new Nutrient("Protein", 1.8, "g"),
                        new Nutrient("Carbohydrates", 8 , "g"),
                        new Nutrient("Fat", 0.5, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED, NutritionFactsResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("mozarella", new NutritionalInfo("mozarella",299,
                List.of(new Nutrient("Protein", 22.2, "g"),
                        new Nutrient("Carbohydrates", 2.4 , "g"),
                        new Nutrient("Fat", 22.1, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED, NutritionFactsResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("albahaca", new NutritionalInfo("albahaca",2,
                List.of(new Nutrient("Protein", 0.3, "g"),
                        new Nutrient("Carbohydrates", 0.3 , "g"),
                        new Nutrient("Fat", 0.1, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED, NutritionFactsResponse.HealthLabel.DAIRY_FREE)));


        //Ensalada César -> Lechuga:1 unidad, Pollo:150g, Crutones:50g, Queso parmesano:30g, Aderezo César:50ml
        nutrientDatabase.put("lechuga", new NutritionalInfo("lechuga",26,
                List.of(new Nutrient("Protein", 2.7, "g"),
                        new Nutrient("Carbohydrates", 4.5 , "g"),
                        new Nutrient("Fat", 0.4, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED, NutritionFactsResponse.HealthLabel.DAIRY_FREE, NutritionFactsResponse.HealthLabel.GLUTEN_FREE)));

        nutrientDatabase.put("pollo", new NutritionalInfo("pollo",323,
                List.of(new Nutrient("Protein", 27.9, "g"),
                        new Nutrient("Carbohydrates", 0 , "g"),
                        new Nutrient("Fat", 22.7, "g")),
                List.of(NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED, NutritionFactsResponse.HealthLabel.DAIRY_FREE, NutritionFactsResponse.HealthLabel.GLUTEN_FREE)));

        nutrientDatabase.put("crutones", new NutritionalInfo("crutones",204,
                List.of(new Nutrient("Protein", 6, "g"),
                        new Nutrient("Carbohydrates", 36.8 , "g"),
                        new Nutrient("Fat", 3.3, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("aderezo cesar", new NutritionalInfo("aderezo cesar",120,
                List.of(new Nutrient("Protein", 9, "g"),
                        new Nutrient("Carbohydrates", 41 , "g"),
                        new Nutrient("Fat", 7, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN)));

        //Crema de calabaza -> Calabaza:500g, Cebolla:1 unidad, Caldo de verduras:500ml, Jengibre:1 cucharadita, Nata:100ml

        nutrientDatabase.put("calabaza", new NutritionalInfo("calabaza",130,
                List.of(new Nutrient("Protein", 5, "g"),
                        new Nutrient("Carbohydrates", 32.5 , "g"),
                        new Nutrient("Fat", 0.5, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.DAIRY_FREE, NutritionFactsResponse.HealthLabel.GLUTEN_FREE, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED)));
        nutrientDatabase.put("cebolla", new NutritionalInfo("cebolla",80,
                List.of(new Nutrient("Protein", 2.2, "g"),
                        new Nutrient("Carbohydrates", 18.7 , "g"),
                        new Nutrient("Fat", 0.2, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.DAIRY_FREE, NutritionFactsResponse.HealthLabel.GLUTEN_FREE, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED)));

        nutrientDatabase.put("caldo de verduras", new NutritionalInfo("caldo de verduras",86,
                List.of(new Nutrient("Protein", 1.4, "g"),
                        new Nutrient("Carbohydrates", 1.2 , "g"),
                        new Nutrient("Fat", 1, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.DAIRY_FREE, NutritionFactsResponse.HealthLabel.GLUTEN_FREE, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED)));

        nutrientDatabase.put("jenjibre", new NutritionalInfo("jenjibre",4,
                List.of(new Nutrient("Protein", 0.1, "g"),
                        new Nutrient("Carbohydrates", 0.9 , "g"),
                        new Nutrient("Fat", 0, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.DAIRY_FREE, NutritionFactsResponse.HealthLabel.GLUTEN_FREE, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED)));

        nutrientDatabase.put("nata", new NutritionalInfo("nata",343,
                List.of(new Nutrient("Protein", 36.4, "g"),
                        new Nutrient("Carbohydrates", 2.9 , "g"),
                        new Nutrient("Fat", 0, "g")),
                List.of( NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.GLUTEN_FREE)));
    }


    public NutritionFactsResponse nutritionFacts(List<String> ingredients) {
        int totalCalories = 0;
        Map<String, Nutrient> nutrientMap = new HashMap<>();
        Set<NutritionFactsResponse.HealthLabel> totalHealthLabels = new HashSet<>();

        for (String item : ingredients) {
            String[] ingredient = item.split(":");
            NutritionalInfo info = nutrientDatabase.get(ingredient[0].toLowerCase());
            if (info != null) {
                totalCalories += info.calories();
                // We merge the nutrients
                for (Nutrient nutrient : info.nutrients()) {
                    Nutrient existing = nutrientMap.get(nutrient.getLabel());
                    if (existing != null) {
                        // If nutrient is already present in map, we add the quantities
                        double newQuantity = existing.getQuantity() + nutrient.getQuantity();
                        nutrientMap.put(nutrient.getLabel(), new Nutrient(nutrient.getLabel(), newQuantity, nutrient.getUnit()));
                    } else {
                        // otherwise we add it
                        nutrientMap.put(nutrient.getLabel(), nutrient);
                    }
                    totalHealthLabels.addAll(info.healthLabels());
                }
            }
        }
        List<Nutrient> totalNutrients = new ArrayList<>(nutrientMap.values());

        return new NutritionFactsResponse(totalCalories, new ArrayList<>(totalHealthLabels), totalNutrients);
    }

    public List<NutritionalInfo> getAll() {
        return nutrientDatabase.values().stream().toList();
    }


}

