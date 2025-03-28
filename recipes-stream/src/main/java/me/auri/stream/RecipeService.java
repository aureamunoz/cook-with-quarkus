package me.auri.stream;

import io.quarkus.logging.Log;
import io.smallrye.common.annotation.RunOnVirtualThread;
import io.smallrye.reactive.messaging.MutinyEmitter;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class RecipeService {

    // In-memory repository for demo purpose
    final Map<String, Recipe> recipes = new ConcurrentHashMap<>();

    @Channel("updates")
    MutinyEmitter<Recipe> updates;

    @RestClient
    TheNutritionFactsService service;

    @Incoming("recipes")
    @RunOnVirtualThread
    void consume(Recipe recipe) {
        Log.infof("Received recipe %s", recipe.name());

        // Enrich, Store (title -> enriched) and send to updates if there is requests
        Recipe enriched = enrich(recipe);
        recipes.put(recipe.name(), enriched);

        if(updates.hasRequests()) {
            updates.sendAndForget(enriched);
        }
    }

    private Recipe enrich(Recipe recipe) {
        var resp = service.analyze(new RecipeDetails(recipe.name(), recipe.ingredients()));
        Log.infof(recipe.name() + " enriched: ");
        return new Recipe(recipe.name(), recipe.description(),recipe.ingredients(), recipe.instructions(), recipe.rating(),resp.calories, resp.healthLabels, resp.nutrients, resp.picture);
    }

    public List<Recipe> getAll() {
        return recipes.values().stream().toList();
    }
}
