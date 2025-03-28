package me.auri.nutrients;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class NutriPicResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/nutripic/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from Nutrients API REST"));
    }

    @Test
    void testNutrientsDetailsEndpoint() {
        String ingredients= "Spaghetti:200g, Huevo:2 unidades, Panceta:100g, Queso parmesano:50g, Pimienta negra:1 pizca";
        RecipeDetails recipeDetails = new RecipeDetails("Spaghetti Carbonara", ingredients);
        Nutrient fats = new Nutrient("Grasas", 60.8, "g");
        Nutrient carbohydrates = new Nutrient("Hidratos de Carbono", 151.6, "g");
        Nutrient proteins = new Nutrient("Proteinas", 68.4, "g");

        NutriPicResponse nutrientsResponse = given()
                .header("Content-Type", "application/json")
                .body(recipeDetails)
                .post("/nutripic")
                .then()
                .statusCode(200)
                .extract().body().as(NutriPicResponse.class);

        assertThat(nutrientsResponse.getTotalCalories()).isEqualTo(1454);
        assertThat(nutrientsResponse.getHealthLabels()).contains(NutriPicResponse.HealthLabel.NO_SUGAR_ADDED.getLabel());
//        assertThat(nutrientsResponse.getNutrients()).containsAnyOf(fats,proteins,carbohydrates);
        assertThat(nutrientsResponse.getPicture()).isNotEmpty();
    }

}