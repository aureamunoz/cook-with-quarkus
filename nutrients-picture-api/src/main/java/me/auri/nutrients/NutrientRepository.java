package me.auri.nutrients;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.logging.Log;
import io.quarkus.runtime.util.ClassPathUtils;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class NutrientRepository {

    private final Map<String, NutritionalInfo> nutrientDatabase = new HashMap<>();

    @PostConstruct
    void init() {
        //Spaghetti Carbonara -> Spaghetti:200g, Huevo:2 unidades, Panceta:100g, Queso parmesano:50g, Pimienta negra:1 pizca
        nutrientDatabase.put("spaghetti", new NutritionalInfo( "spaghetti",742,
                List.of(new Nutrient("Grasas", 3, "g"),
                        new Nutrient("Hidratos de Carbono", 149.4, "g"),
                        new Nutrient("Proteinas", 26, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN)));

        nutrientDatabase.put("huevo", new NutritionalInfo("huevo",123,
                List.of(new Nutrient("Proteinas", 10.8, "g"),
                        new Nutrient("Hidratos de Carbono", 0.6, "g"),
                        new Nutrient("Grasas", 8.2, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED, NutritionFactsResponse.HealthLabel.GLUTEN_FREE, NutritionFactsResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("panceta", new NutritionalInfo("panceta",393,
                List.of(new Nutrient("Proteinas", 13.7, "g"),
                        new Nutrient("Hidratos de Carbono", 0, "g"),
                        new Nutrient("Grasas", 37.1, "g")),
                List.of(NutritionFactsResponse.HealthLabel.GLUTEN_FREE)));

        nutrientDatabase.put("queso parmesano", new NutritionalInfo("queso parmesano",196,
                List.of(new Nutrient("Proteinas", 17.9, "g"),
                        new Nutrient("Hidratos de Carbono", 1.6, "g"),
                        new Nutrient("Grasas", 12.5, "g")),
                List.of(NutritionFactsResponse.HealthLabel.GLUTEN_FREE)));

        nutrientDatabase.put("pimienta negra", new NutritionalInfo("pimienta negra",0,
                List.of(new Nutrient("Proteinas", 0, "g"),
                        new Nutrient("Hidratos de Carbono", 0, "g"),
                        new Nutrient("Grasas", 0, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED, NutritionFactsResponse.HealthLabel.GLUTEN_FREE, NutritionFactsResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("sal", new NutritionalInfo("sal",0,
                List.of(new Nutrient("Sodium", 147.5, "mg")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED, NutritionFactsResponse.HealthLabel.GLUTEN_FREE, NutritionFactsResponse.HealthLabel.DAIRY_FREE)));


        //Pizza Margarita -> Harina:300g, Agua:200ml, Levadura:5g, Tomate:150g, Mozzarella:100g, Albahaca:5 hojas
        nutrientDatabase.put("harina", new NutritionalInfo("harina",1092,
                List.of(new Nutrient("Proteinas", 30.9, "g"),
                        new Nutrient("Hidratos de Carbono", 228.9, "g"),
                        new Nutrient("Grasas", 2.9, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN)));

        nutrientDatabase.put("agua", new NutritionalInfo("agua",0,
                List.of(new Nutrient("Proteinas", 0, "g"),
                        new Nutrient("Hidratos de Carbono", 0, "g"),
                        new Nutrient("Grasas", 0, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED, NutritionFactsResponse.HealthLabel.GLUTEN_FREE, NutritionFactsResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("levadura", new NutritionalInfo("levadura",16,
                List.of(new Nutrient("Proteinas", 2, "g"),
                        new Nutrient("Hidratos de Carbono", 2.1 , "g"),
                        new Nutrient("Grasas", 0.4, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED, NutritionFactsResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("tomate", new NutritionalInfo("tomate",36,
                List.of(new Nutrient("Proteinas", 1.8, "g"),
                        new Nutrient("Hidratos de Carbono", 8 , "g"),
                        new Nutrient("Grasas", 0.5, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED, NutritionFactsResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("mozarella", new NutritionalInfo("mozarella",299,
                List.of(new Nutrient("Proteinas", 22.2, "g"),
                        new Nutrient("Hidratos de Carbono", 2.4 , "g"),
                        new Nutrient("Grasas", 22.1, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED, NutritionFactsResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("albahaca", new NutritionalInfo("albahaca",2,
                List.of(new Nutrient("Proteinas", 0.3, "g"),
                        new Nutrient("Hidratos de Carbono", 0.3 , "g"),
                        new Nutrient("Grasas", 0.1, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED, NutritionFactsResponse.HealthLabel.DAIRY_FREE)));


        //Ensalada César -> Lechuga:1 unidad, Pollo:150g, Crutones:50g, Queso parmesano:30g, Aderezo César:50ml
        nutrientDatabase.put("lechuga", new NutritionalInfo("lechuga",26,
                List.of(new Nutrient("Proteinas", 2.7, "g"),
                        new Nutrient("Hidratos de Carbono", 4.5 , "g"),
                        new Nutrient("Grasas", 0.4, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED, NutritionFactsResponse.HealthLabel.DAIRY_FREE, NutritionFactsResponse.HealthLabel.GLUTEN_FREE)));

        nutrientDatabase.put("pollo", new NutritionalInfo("pollo",323,
                List.of(new Nutrient("Proteinas", 27.9, "g"),
                        new Nutrient("Hidratos de Carbono", 0 , "g"),
                        new Nutrient("Grasas", 22.7, "g")),
                List.of(NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED, NutritionFactsResponse.HealthLabel.DAIRY_FREE, NutritionFactsResponse.HealthLabel.GLUTEN_FREE)));

        nutrientDatabase.put("crutones", new NutritionalInfo("crutones",204,
                List.of(new Nutrient("Proteinas", 6, "g"),
                        new Nutrient("Hidratos de Carbono", 36.8 , "g"),
                        new Nutrient("Grasas", 3.3, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.DAIRY_FREE)));

        nutrientDatabase.put("aderezo cesar", new NutritionalInfo("aderezo cesar",120,
                List.of(new Nutrient("Proteinas", 9, "g"),
                        new Nutrient("Hidratos de Carbono", 41 , "g"),
                        new Nutrient("Grasas", 7, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN)));

        //Crema de calabaza -> Calabaza:500g, Cebolla:1 unidad, Caldo de verduras:500ml, Jengibre:1 cucharadita, Nata:100ml

        nutrientDatabase.put("calabaza", new NutritionalInfo("calabaza",130,
                List.of(new Nutrient("Proteinas", 5, "g"),
                        new Nutrient("Hidratos de Carbono", 32.5 , "g"),
                        new Nutrient("Grasas", 0.5, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.DAIRY_FREE, NutritionFactsResponse.HealthLabel.GLUTEN_FREE, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED)));
        nutrientDatabase.put("cebolla", new NutritionalInfo("cebolla",80,
                List.of(new Nutrient("Proteinas", 2.2, "g"),
                        new Nutrient("Hidratos de Carbono", 18.7 , "g"),
                        new Nutrient("Grasas", 0.2, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.DAIRY_FREE, NutritionFactsResponse.HealthLabel.GLUTEN_FREE, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED)));

        nutrientDatabase.put("caldo de verduras", new NutritionalInfo("caldo de verduras",86,
                List.of(new Nutrient("Proteinas", 1.4, "g"),
                        new Nutrient("Hidratos de Carbono", 1.2 , "g"),
                        new Nutrient("Grasas", 1, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.DAIRY_FREE, NutritionFactsResponse.HealthLabel.GLUTEN_FREE, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED)));

        nutrientDatabase.put("jenjibre", new NutritionalInfo("jenjibre",4,
                List.of(new Nutrient("Proteinas", 0.1, "g"),
                        new Nutrient("Hidratos de Carbono", 0.9 , "g"),
                        new Nutrient("Grasas", 0, "g")),
                List.of(NutritionFactsResponse.HealthLabel.VEGAN, NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.DAIRY_FREE, NutritionFactsResponse.HealthLabel.GLUTEN_FREE, NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED)));

        nutrientDatabase.put("nata", new NutritionalInfo("nata",343,
                List.of(new Nutrient("Proteinas", 36.4, "g"),
                        new Nutrient("Hidratos de Carbono", 2.9 , "g"),
                        new Nutrient("Grasas", 0, "g")),
                List.of( NutritionFactsResponse.HealthLabel.VEGETARIAN, NutritionFactsResponse.HealthLabel.GLUTEN_FREE)));
    }


    public NutritionFactsResponse nutritionFacts(String ingredients) throws IOException, URISyntaxException {
        int totalCalories = 0;
        Map<String, Nutrient> nutrientMap = new HashMap<>();
        Set<String> totalHealthLabels = new HashSet<>();
        String[] splitted = ingredients.split(",");
        for(int i = 0; i < splitted.length; i++){
            String[] ingredient = splitted[i].trim().split(":");
//            Log.info(" ----- Analizing " + ingredient[0]);
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
                    totalHealthLabels.addAll(info.healthLabels().stream().map(healthLabel -> healthLabel.getLabel()).collect(Collectors.toList()));
                }
            }
        }
        List<Nutrient> totalNutrients = new ArrayList<>(nutrientMap.values());
        String image = convertImageToBase64("pizza.jpg");
        NutritionFactsResponse nutritionFactsResponse = new NutritionFactsResponse(totalCalories, new ArrayList<>(totalHealthLabels), totalNutrients, image);
        return nutritionFactsResponse;
    }

    private String convertImageToBase64(String imagePath) throws IOException, URISyntaxException {
        File imageFile = getFileFromResources(imagePath);
        if (imageFile.exists()) {
            FileInputStream fileInputStream = new FileInputStream(imageFile);
            byte[] imageData = new byte[(int) imageFile.length()];
            fileInputStream.read(imageData);
            fileInputStream.close();
            return Base64.getEncoder().encodeToString(imageData);
        } else {
            throw new IOException("Image file not found: " + imagePath);
        }
    }

    public  File getFileFromResources(String fileName) throws URISyntaxException {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        } else {
            return new File(resource.toURI());
        }


    }

    public List<NutritionalInfo> getAll() {
        return nutrientDatabase.values().stream().toList();
    }


}

