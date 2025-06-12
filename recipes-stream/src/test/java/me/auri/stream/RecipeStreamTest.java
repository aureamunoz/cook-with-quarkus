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
    void testDeserializationJson() throws JsonProcessingException {
        String json = "{ \"totalCalories\": 742, \"healthLabels\": \"VEGETARIAN, VEGAN\", \"nutrients\":\"Grasas: 60.8 g Hidratos de Carbono: 151.6 g Proteinas: 68.4 g\", \"picture\":\"0943853kjfñljhflkfj4375349uroweiuro\" }";

        ObjectMapper objectMapper = new ObjectMapper();
        TheNutritionFactsService.NutrientInfo info = objectMapper.readValue(json,
                TheNutritionFactsService.NutrientInfo.class);

        System.out.println("Calorías: " + info.calories);
        System.out.println("Health Labels: " + info.healthLabels);
        System.out.println("Nutrients: " + info.nutrients);
    }

}
