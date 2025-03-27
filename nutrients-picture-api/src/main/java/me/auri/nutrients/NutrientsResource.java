package me.auri.nutrients;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

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
    public NutritionFactsResponse getNutrientsDetails(String ingredients) throws IOException, URISyntaxException {
        Log.infof("Ingredients received:  %s", ingredients);
        return nutrientRepository.nutritionFacts(ingredients);
    }


}
