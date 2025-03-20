package me.auri.nutrients;

import io.quarkus.test.junit.QuarkusTest;
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
          .when().get("/nutrients/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from Nutrients API REST"));
    }

    @Test
    void testNutrientsDetailsEndpoint() {

//        Spaghetti:200g, Huevo:2 unidades, Panceta:100g, Queso parmesano:50g, Pimienta negra:1 pizca
        List<String> ingredients = Arrays.asList("Spaghetti:200g","Huevo:2 unidades", "Panceta:100g", "Queso parmesano:50g", "Pimienta negra:1 pizca");
        Nutrient fats = new Nutrient("Fat", 60.8, "g");
        Nutrient carbohydrates = new Nutrient("Carbohydrates", 151.6, "g");
        Nutrient proteins = new Nutrient("Protein", 68.4, "g");

        NutritionFactsResponse nutrientsResponse = given()
                .header("Content-Type", "application/json")
                .body(ingredients)
                .post("/nutrients")
                .then()
                .statusCode(200)
                .extract().body().as(NutritionFactsResponse.class);

        assertThat(nutrientsResponse.getTotalCalories()).isEqualTo(1454);
        assertThat(nutrientsResponse.getHealthLabels()).contains(NutritionFactsResponse.HealthLabel.NO_SUGAR_ADDED);
        assertThat(nutrientsResponse.getNutrients()).containsAnyOf(fats,proteins,carbohydrates);
    }

}