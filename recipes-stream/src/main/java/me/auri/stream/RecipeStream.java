package me.auri.stream;

import io.quarkus.logging.Log;
import io.smallrye.common.annotation.RunOnVirtualThread;
import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.MutinyEmitter;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestStreamElementType;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Path("/recipes")
public class RecipeStream {

    @Inject
    RecipeService recipeService;

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
