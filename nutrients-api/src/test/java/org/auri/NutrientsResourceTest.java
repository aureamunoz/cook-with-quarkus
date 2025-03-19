package org.auri;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class NutrientsResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/nutrients")
          .then()
             .statusCode(200)
             .body(is("Hello from Nutrients API REST"));
    }

    @Test
    void testNutrientsDetailsEndpoint() {

//        Spaghetti:200g, Huevo:2 unidades, Panceta:100g, Queso parmesano:50g, Pimienta negra:1 pizca
        List<String> ingredients = Arrays.asList("Spaghetti:200g","Huevo:2 unidades", "Panceta:100g", "Queso parmesano:50g", "Pimienta negra:1 pizca");
        Nutrient energy = new Nutrient("Energia", 1453.98, "kcal");
        Nutrient fat = new Nutrient("Grasas", 60.79, "g");
        Nutrient carbohydrates = new Nutrient("Carbohidratos", 145.229, "g");

        NutrientsResponse nutrientsResponse = given()
                .header("Content-Type", "application/json")
                .body(ingredients)
                .post("/nutrients")
                .then()
                .statusCode(200)
                .extract().body().as(NutrientsResponse.class);

        assertThat(nutrientsResponse.getCalories()).isEqualTo(1454);
        assertThat(nutrientsResponse.getHealthLabels()).contains(NutrientsResponse.HealthLabel.NO_SUGAR_ADDED);
        assertThat(nutrientsResponse.getNutrients()).containsAnyOf(energy,fat,carbohydrates);
    }

}