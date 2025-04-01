package me.auri.nutrients;

import io.quarkus.logging.Log;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class NutriPicEnhancer {

    private final Map<String, NutritionalFacts> nutrientDatabase = new HashMap<>();

    @PostConstruct
    void init() {
        // Spaghetti Carbonara -> Spaghetti:200g, Huevo:2 unidades, Panceta:100g, Queso parmesano:50g, Pimienta negra:1
        // pizca
        nutrientDatabase.put("spaghetti",
                new NutritionalFacts("spaghetti", 742,
                        List.of(new Nutrient("Grasas", 3, "g"), new Nutrient("Hidratos de Carbono", 149.4, "g"),
                                new Nutrient("Proteinas", 26, "g")),
                        List.of(NutriPicResponse.HealthLabel.VEGAN, NutriPicResponse.HealthLabel.VEGETARIAN)));

        nutrientDatabase.put("huevo",
                new NutritionalFacts("huevo", 123,
                        List.of(new Nutrient("Proteinas", 10.8, "g"), new Nutrient("Hidratos de Carbono", 0.6, "g"),
                                new Nutrient("Grasas", 8.2, "g")),
                        List.of(NutriPicResponse.HealthLabel.VEGETARIAN, NutriPicResponse.HealthLabel.NO_SUGAR_ADDED,
                                NutriPicResponse.HealthLabel.GLUTEN_FREE, NutriPicResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("panceta",
                new NutritionalFacts(
                        "panceta", 393, List.of(new Nutrient("Proteinas", 13.7, "g"),
                                new Nutrient("Hidratos de Carbono", 0, "g"), new Nutrient("Grasas", 37.1, "g")),
                        List.of(NutriPicResponse.HealthLabel.GLUTEN_FREE)));

        nutrientDatabase.put("queso parmesano",
                new NutritionalFacts(
                        "queso parmesano", 196, List.of(new Nutrient("Proteinas", 17.9, "g"),
                                new Nutrient("Hidratos de Carbono", 1.6, "g"), new Nutrient("Grasas", 12.5, "g")),
                        List.of(NutriPicResponse.HealthLabel.GLUTEN_FREE)));

        nutrientDatabase.put("pimienta negra",
                new NutritionalFacts("pimienta negra", 0,
                        List.of(new Nutrient("Proteinas", 0, "g"), new Nutrient("Hidratos de Carbono", 0, "g"),
                                new Nutrient("Grasas", 0, "g")),
                        List.of(NutriPicResponse.HealthLabel.VEGAN, NutriPicResponse.HealthLabel.VEGETARIAN,
                                NutriPicResponse.HealthLabel.NO_SUGAR_ADDED, NutriPicResponse.HealthLabel.GLUTEN_FREE,
                                NutriPicResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("sal",
                new NutritionalFacts("sal", 0, List.of(new Nutrient("Sodium", 147.5, "mg")),
                        List.of(NutriPicResponse.HealthLabel.VEGAN, NutriPicResponse.HealthLabel.VEGETARIAN,
                                NutriPicResponse.HealthLabel.NO_SUGAR_ADDED, NutriPicResponse.HealthLabel.GLUTEN_FREE,
                                NutriPicResponse.HealthLabel.DAIRY_FREE)));

        // Pizza Margarita -> Harina:300g, Agua:200ml, Levadura:5g, Tomate:150g, Mozzarella:100g, Albahaca:5 hojas
        nutrientDatabase.put("harina",
                new NutritionalFacts("harina", 1092,
                        List.of(new Nutrient("Proteinas", 30.9, "g"), new Nutrient("Hidratos de Carbono", 228.9, "g"),
                                new Nutrient("Grasas", 2.9, "g")),
                        List.of(NutriPicResponse.HealthLabel.VEGAN, NutriPicResponse.HealthLabel.VEGETARIAN)));

        nutrientDatabase.put("agua",
                new NutritionalFacts("agua", 0,
                        List.of(new Nutrient("Proteinas", 0, "g"), new Nutrient("Hidratos de Carbono", 0, "g"),
                                new Nutrient("Grasas", 0, "g")),
                        List.of(NutriPicResponse.HealthLabel.VEGAN, NutriPicResponse.HealthLabel.VEGETARIAN,
                                NutriPicResponse.HealthLabel.NO_SUGAR_ADDED, NutriPicResponse.HealthLabel.GLUTEN_FREE,
                                NutriPicResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("levadura",
                new NutritionalFacts("levadura", 16,
                        List.of(new Nutrient("Proteinas", 2, "g"), new Nutrient("Hidratos de Carbono", 2.1, "g"),
                                new Nutrient("Grasas", 0.4, "g")),
                        List.of(NutriPicResponse.HealthLabel.VEGAN, NutriPicResponse.HealthLabel.VEGETARIAN,
                                NutriPicResponse.HealthLabel.NO_SUGAR_ADDED, NutriPicResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("tomate",
                new NutritionalFacts("tomate", 36,
                        List.of(new Nutrient("Proteinas", 1.8, "g"), new Nutrient("Hidratos de Carbono", 8, "g"),
                                new Nutrient("Grasas", 0.5, "g")),
                        List.of(NutriPicResponse.HealthLabel.VEGAN, NutriPicResponse.HealthLabel.VEGETARIAN,
                                NutriPicResponse.HealthLabel.NO_SUGAR_ADDED, NutriPicResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("mozarella",
                new NutritionalFacts("mozarella", 299,
                        List.of(new Nutrient("Proteinas", 22.2, "g"), new Nutrient("Hidratos de Carbono", 2.4, "g"),
                                new Nutrient("Grasas", 22.1, "g")),
                        List.of(NutriPicResponse.HealthLabel.VEGAN, NutriPicResponse.HealthLabel.VEGETARIAN,
                                NutriPicResponse.HealthLabel.NO_SUGAR_ADDED, NutriPicResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("albahaca",
                new NutritionalFacts("albahaca", 2,
                        List.of(new Nutrient("Proteinas", 0.3, "g"), new Nutrient("Hidratos de Carbono", 0.3, "g"),
                                new Nutrient("Grasas", 0.1, "g")),
                        List.of(NutriPicResponse.HealthLabel.VEGAN, NutriPicResponse.HealthLabel.VEGETARIAN,
                                NutriPicResponse.HealthLabel.NO_SUGAR_ADDED, NutriPicResponse.HealthLabel.DAIRY_FREE)));

        // Ensalada César -> Lechuga:1 unidad, Pollo:150g, Crutones:50g, Queso parmesano:30g, Aderezo César:50ml
        nutrientDatabase.put("lechuga",
                new NutritionalFacts("lechuga", 26,
                        List.of(new Nutrient("Proteinas", 2.7, "g"), new Nutrient("Hidratos de Carbono", 4.5, "g"),
                                new Nutrient("Grasas", 0.4, "g")),
                        List.of(NutriPicResponse.HealthLabel.VEGAN, NutriPicResponse.HealthLabel.VEGETARIAN,
                                NutriPicResponse.HealthLabel.NO_SUGAR_ADDED, NutriPicResponse.HealthLabel.DAIRY_FREE,
                                NutriPicResponse.HealthLabel.GLUTEN_FREE)));

        nutrientDatabase.put("pollo",
                new NutritionalFacts("pollo", 323,
                        List.of(new Nutrient("Proteinas", 27.9, "g"), new Nutrient("Hidratos de Carbono", 0, "g"),
                                new Nutrient("Grasas", 22.7, "g")),
                        List.of(NutriPicResponse.HealthLabel.NO_SUGAR_ADDED, NutriPicResponse.HealthLabel.DAIRY_FREE,
                                NutriPicResponse.HealthLabel.GLUTEN_FREE)));

        nutrientDatabase.put("crutones",
                new NutritionalFacts("crutones", 204,
                        List.of(new Nutrient("Proteinas", 6, "g"), new Nutrient("Hidratos de Carbono", 36.8, "g"),
                                new Nutrient("Grasas", 3.3, "g")),
                        List.of(NutriPicResponse.HealthLabel.VEGAN, NutriPicResponse.HealthLabel.VEGETARIAN,
                                NutriPicResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("aderezo cesar",
                new NutritionalFacts("aderezo cesar", 120,
                        List.of(new Nutrient("Proteinas", 9, "g"), new Nutrient("Hidratos de Carbono", 41, "g"),
                                new Nutrient("Grasas", 7, "g")),
                        List.of(NutriPicResponse.HealthLabel.VEGAN, NutriPicResponse.HealthLabel.VEGETARIAN)));

        // Crema de calabaza -> Calabaza:500g, Cebolla:1 unidad, Caldo de verduras:500ml, Jengibre:1 cucharadita,
        // Nata:100ml

        nutrientDatabase.put("calabaza",
                new NutritionalFacts("calabaza", 130,
                        List.of(new Nutrient("Proteinas", 5, "g"), new Nutrient("Hidratos de Carbono", 32.5, "g"),
                                new Nutrient("Grasas", 0.5, "g")),
                        List.of(NutriPicResponse.HealthLabel.VEGAN, NutriPicResponse.HealthLabel.VEGETARIAN,
                                NutriPicResponse.HealthLabel.DAIRY_FREE, NutriPicResponse.HealthLabel.GLUTEN_FREE,
                                NutriPicResponse.HealthLabel.NO_SUGAR_ADDED)));
        nutrientDatabase.put("cebolla",
                new NutritionalFacts("cebolla", 80,
                        List.of(new Nutrient("Proteinas", 2.2, "g"), new Nutrient("Hidratos de Carbono", 18.7, "g"),
                                new Nutrient("Grasas", 0.2, "g")),
                        List.of(NutriPicResponse.HealthLabel.VEGAN, NutriPicResponse.HealthLabel.VEGETARIAN,
                                NutriPicResponse.HealthLabel.DAIRY_FREE, NutriPicResponse.HealthLabel.GLUTEN_FREE,
                                NutriPicResponse.HealthLabel.NO_SUGAR_ADDED)));

        nutrientDatabase.put("caldo de verduras",
                new NutritionalFacts("caldo de verduras", 86,
                        List.of(new Nutrient("Proteinas", 1.4, "g"), new Nutrient("Hidratos de Carbono", 1.2, "g"),
                                new Nutrient("Grasas", 1, "g")),
                        List.of(NutriPicResponse.HealthLabel.VEGAN, NutriPicResponse.HealthLabel.VEGETARIAN,
                                NutriPicResponse.HealthLabel.DAIRY_FREE, NutriPicResponse.HealthLabel.GLUTEN_FREE,
                                NutriPicResponse.HealthLabel.NO_SUGAR_ADDED)));

        nutrientDatabase.put("jenjibre",
                new NutritionalFacts("jenjibre", 4,
                        List.of(new Nutrient("Proteinas", 0.1, "g"), new Nutrient("Hidratos de Carbono", 0.9, "g"),
                                new Nutrient("Grasas", 0, "g")),
                        List.of(NutriPicResponse.HealthLabel.VEGAN, NutriPicResponse.HealthLabel.VEGETARIAN,
                                NutriPicResponse.HealthLabel.DAIRY_FREE, NutriPicResponse.HealthLabel.GLUTEN_FREE,
                                NutriPicResponse.HealthLabel.NO_SUGAR_ADDED)));

        nutrientDatabase.put("nata",
                new NutritionalFacts("nata", 343,
                        List.of(new Nutrient("Proteinas", 36.4, "g"), new Nutrient("Hidratos de Carbono", 2.9, "g"),
                                new Nutrient("Grasas", 0, "g")),
                        List.of(NutriPicResponse.HealthLabel.VEGETARIAN, NutriPicResponse.HealthLabel.GLUTEN_FREE)));
    }

    public NutriPicResponse nutritionFacts(String ingredients) {
        int totalCalories = 0;
        Map<String, Nutrient> nutrientMap = new HashMap<>();
        Set<String> totalHealthLabels = new HashSet<>();
        String[] splitted = ingredients.split(",");
        for (int i = 0; i < splitted.length; i++) {
            String[] ingredient = splitted[i].trim().split(":");
            NutritionalFacts info = nutrientDatabase.get(ingredient[0].toLowerCase());
            if (info != null) {
                totalCalories += info.calories();
                // We merge the nutrients
                for (Nutrient nutrient : info.nutrients()) {
                    Nutrient existing = nutrientMap.get(nutrient.getLabel());
                    if (existing != null) {
                        // If nutrient is already present in map, we add the quantities
                        double newQuantity = existing.getQuantity() + nutrient.getQuantity();
                        nutrientMap.put(nutrient.getLabel(),
                                new Nutrient(nutrient.getLabel(), newQuantity, nutrient.getUnit()));
                    } else {
                        // otherwise we add it
                        nutrientMap.put(nutrient.getLabel(), nutrient);
                    }
                    totalHealthLabels.addAll(info.healthLabels().stream().map(healthLabel -> healthLabel.getLabel())
                            .collect(Collectors.toList()));
                }
            }
        }
        List<Nutrient> totalNutrients = new ArrayList<>(nutrientMap.values());
        NutriPicResponse nutriPicResponse = new NutriPicResponse();
        nutriPicResponse.setTotalCalories(totalCalories);
        nutriPicResponse.setNutrients(formatNutrients(totalNutrients));
        nutriPicResponse.setHealthLabels(totalHealthLabels.stream().collect(Collectors.joining(", ")));
        Log.info("Nutrition Facts: ");
        Log.infof("Total calories: %s", nutriPicResponse.getTotalCalories());
        Log.infof("Health labels: %s", nutriPicResponse.getHealthLabels());
        Log.infof("Nutrients: %s", nutriPicResponse.getNutrients());
        return nutriPicResponse;
    }

    public String getPic(String recipeName) {
        String base64 = convertImageToBase64(recipeName.toLowerCase().trim().replaceAll("\\s+", "") + ".jpg");
        if (!base64.isBlank()) {
            Log.infof("Image found for ", recipeName);
        } else {
            Log.infof("Image for %s not found", recipeName);
        }
        return base64;

    }

    private String formatNutrients(List<Nutrient> nutrients) {
        StringBuilder sb = new StringBuilder();
        for (Nutrient nutrient : nutrients) {
            sb.append(nutrient.toString()).append(" ");
        }
        return sb.toString();
    }

    private String convertImageToBase64(String imagePath) {
        try {
            URL resource = Thread.currentThread().getContextClassLoader().getResource(imagePath);
            if (resource != null) {
                File imageFile = new File(resource.toURI());
                if (imageFile.exists()) {
                    byte[] imageData = Files.readAllBytes(imageFile.toPath());
                    return Base64.getEncoder().encodeToString(imageData);

                }
            }
        } catch (Exception e) {
            Log.errorf("Error processing image file %s: %s", imagePath, e.getMessage());
        }
        return "";
    }

    public List<NutritionalFacts> getAll() {
        return nutrientDatabase.values().stream().toList();
    }

}
