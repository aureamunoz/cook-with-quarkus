package me.auri.stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class RecipeStreamTest {
    @Test
    void testHelloEndpoint() {
        given().when().get("/hello").then().statusCode(200).body(is("Hello from Quarkus REST"));
    }

    @Test
    void testDeserializationJson() throws JsonProcessingException {
        String json = "{ \"calories\": 742, \"healthLabels\": [\"VEGETARIAN\", \"VEGAN\"], \"nutrients\": [{\"label\": \"Carbohydrates\", \"quantity\": 149.4, \"unit\": \"g\"}, {\"label\": \"Fat\", \"quantity\": 3, \"unit\": \"g\"}, {\"label\": \"Protein\", \"quantity\": 26, \"unit\": \"g\"} ] }";

        ObjectMapper objectMapper = new ObjectMapper();
        TheNutritionFactsService.NutrientInfo info = objectMapper.readValue(json,
                TheNutritionFactsService.NutrientInfo.class);

        System.out.println("Calorías: " + info.calories);
        System.out.println("Health Labels: " + info.healthLabels);
        System.out.println("Nutrients: " + info.nutrients);
    }

}
