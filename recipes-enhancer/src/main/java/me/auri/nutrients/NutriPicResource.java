package me.auri.nutrients;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Path("/nutripic")
public class NutriPicResource {

    @Inject
    NutriPicEnhancer nutriPicEnhancer;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Nutrients API REST";
    }

    @GET
    public List<NutritionalFacts> getAll() {
        return nutriPicEnhancer.getAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public NutriPicResponse getNutrientsAndPicture(@QueryParam("recipe")String recipe, @QueryParam("ingredients") String ingredients) throws IOException, URISyntaxException {
        Log.infof("Marchando %s!! ", recipe);
        final NutriPicResponse nutriPicResponse = nutriPicEnhancer.nutritionFacts(ingredients);
        nutriPicResponse.setPicture(nutriPicEnhancer.getPic(recipe));
        return nutriPicResponse;
    }


}
