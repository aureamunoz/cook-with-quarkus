package org.auri;

import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

import java.util.List;


@QuarkusTest
public class RecipeControllerTest {

    static final TypeRef<List<Recipe>> LIST_OF_RECIPES = new TypeRef<List<Recipe>>() {
        // Kept empty on purpose
    };


    @Test
    void test(){

        // Crear recetas
        Recipe pancakes = new Recipe();
        pancakes.name = "Pancakes";
        pancakes.description = "Receta fácil para hacer panqueques esponjosos.";
        pancakes.instructions = "Mezclar harina, huevos y leche. Cocinar en sartén.";
        pancakes.rating = 5;
        pancakes.ingredients="Harina:200g, Huevo:2, Leche:250ml";

        Recipe omelette = new Recipe();
        omelette.name = "Omelette";
        omelette.description = "Delicioso omelette con huevo.";
        omelette.instructions = "Batir los huevos y cocinar en sartén.";
        omelette.rating = 4;
        omelette.ingredients="Huevo:3";


        Assertions.assertTrue(RestAssured
                .given()
                .header("Content-Type", "application/json")
                .get("/recipes")
                .then()
                .statusCode(200)
                .extract().body().as(LIST_OF_RECIPES).isEmpty()
        );

        Assertions.assertEquals("Pancakes", RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(pancakes)
                .post("/recipes")
                .then()
                .statusCode(200)
                .extract().body().as(Recipe.class).name);

        omelette = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(omelette)
                .post("/recipes")
                .then()
                .statusCode(200)
                .extract().body().as(Recipe.class);

        Assertions.assertEquals("Omelette", omelette.name);

        Assertions.assertEquals(2, RestAssured
                .given()
                .header("Content-Type", "application/json")
                .get("/recipes")
                .then()
                .statusCode(200)
                .extract().body().as(LIST_OF_RECIPES).size());

        RestAssured.given()
                .delete("/recipes/" + omelette.id).then().statusCode(204);

        Assertions.assertEquals(1, RestAssured
                .given()
                .header("Content-Type", "application/json")
                .get("/recipes")
                .then()
                .statusCode(200)
                .extract().body().as(LIST_OF_RECIPES).size());

    }
}
