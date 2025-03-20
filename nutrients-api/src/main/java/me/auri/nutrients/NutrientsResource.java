package me.auri.nutrients;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/nutrients")
public class NutrientsResource {

    @Inject
    NutrientRepository nutrientRepository;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Nutrients API REST";
    }

    @GET
    public List<NutritionalInfo> getAll() {
        return nutrientRepository.getAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public NutritionFactsResponse getNutrientsDetails(List<String> ingredients) {
//        Nutrient energy = new Nutrient("Energia", 1453.98, "kcal");
//        Nutrient fat = new Nutrient("Grasas", 60.79, "g");
//        Nutrient carbohydrates = new Nutrient("Carbohidratos", 145.229, "g");
//        List<Nutrient> nutrients = Arrays.asList(energy,fat,carbohydrates);
//        List<NutrientsResponse.HealthLabel> labels = Arrays.asList(NutrientsResponse.HealthLabel.NO_SUGAR_ADDED);
//        NutrientsResponse nutrientsResponse = new NutrientsResponse(1454,labels,nutrients);
//        return nutrientsResponse;

        return nutrientRepository.nutritionFacts(ingredients);

    }
}
