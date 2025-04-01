package me.auri.stream;

import io.smallrye.mutiny.Multi;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.resteasy.reactive.RestStreamElementType;

import java.util.List;

@Path("/recipes")
public class RecipeStream {

    @Inject
    RecipeStreamService recipeService;

    @Channel("updates")
    Multi<Recipe> updates;

    @GET
    public List<Recipe> getAll() {
        return recipeService.getAll();
    }

    @GET
    @Path("/stream")
    @RestStreamElementType(MediaType.APPLICATION_JSON)
    public Multi<Recipe> stream() {
        return updates;
    }

}
