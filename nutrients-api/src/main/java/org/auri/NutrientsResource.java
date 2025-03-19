package org.auri;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.Arrays;
import java.util.List;

@Path("/nutrients")
public class NutrientsResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Nutrients API REST";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public NutrientsResponse getNutrientsDetails(List<String> ingredients) {
        Nutrient energy = new Nutrient("Energia", 1453.98, "kcal");
        Nutrient fat = new Nutrient("Grasas", 60.79, "g");
        Nutrient carbohydrates = new Nutrient("Carbohidratos", 145.229, "g");
        List<Nutrient> nutrients = Arrays.asList(energy,fat,carbohydrates);
        List<NutrientsResponse.HealthLabel> labels = Arrays.asList(NutrientsResponse.HealthLabel.NO_SUGAR_ADDED);

        NutrientsResponse nutrientsResponse = new NutrientsResponse();
        nutrientsResponse.setCalories(1454);
        nutrientsResponse.setNutrients(nutrients);
        nutrientsResponse.setHealthLabels(labels);
        return nutrientsResponse;
    }
}
