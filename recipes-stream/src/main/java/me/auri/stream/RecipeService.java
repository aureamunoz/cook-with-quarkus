package me.auri.stream;

import io.quarkus.logging.Log;
import io.smallrye.common.annotation.RunOnVirtualThread;
import io.smallrye.reactive.messaging.MutinyEmitter;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

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
        String healthLabels = resp.healthLabels.stream().collect(Collectors.joining(", "));
        Log.info("HealthLabels: " + healthLabels);
        String nutrients = formatNutrients(resp.nutrients);
        Log.info(nutrients);
        return new Recipe(recipe.name(), recipe.description(),recipe.ingredients(), recipe.instructions(), recipe.rating(),resp.calories, healthLabels, nutrients, resp.picture);
    }

    private String formatNutrients(List<TheNutritionFactsService.NutrientInfo.Nutrient> nutrients) {
        StringBuilder sb = new StringBuilder();
        for (TheNutritionFactsService.NutrientInfo.Nutrient nutrient : nutrients) {
            sb.append(nutrient.toString()).append(" ");
        }
        return sb.toString();
    }

    public List<Recipe> getAll() {
        return recipes.values().stream().toList();
    }
}
