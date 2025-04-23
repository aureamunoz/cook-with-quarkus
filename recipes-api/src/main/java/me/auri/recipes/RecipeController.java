package me.auri.recipes;

import io.quarkus.logging.Log;
import io.smallrye.common.annotation.RunOnVirtualThread;
import io.smallrye.reactive.messaging.MutinyEmitter;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recipes")
@RunOnVirtualThread
public class RecipeController {

    @Channel("recipes")
    MutinyEmitter<Recipe> emitter;

    @Inject
    CookAiService cookAiService;

    @GetMapping
    public List<Recipe> getAll() {
        return Recipe.listAll();
    }

    @PostMapping
    @Transactional
    public Recipe addRecipe(Recipe recipe) {
        Log.infof("Adding a recipe: %s", recipe.name);
        recipe.persist();
        emitter.sendAndAwait(recipe);
        return recipe;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public Response deleteRecipe(@PathVariable Long id) {
        Log.infof("Deleting a recipe with id: %d", id);
        Recipe recipe = Recipe.findById(id);
        if (recipe != null) {
            recipe.delete();
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PostMapping("/new")
    public Recipe cookSomethingWith(@RequestParam String ingredients) {
        Log.infof("Cooking new recipe with: %s ", ingredients);
        return cookAiService.cookSomethingWith(ingredients);
    }

}
