package me.auri.stream;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RegisterRestClient(baseUri = "http://localhost:8083/nutripic")
public interface TheNutritionFactsService {

    @POST
    @Retry(maxRetries = 4, delay = 1, delayUnit = ChronoUnit.SECONDS)
    @Timeout(1000)
    NutrientInfo analyze(RecipeDetails nutritionQuery);

    class NutrientInfo {

        @JsonProperty("totalCalories")
        public int calories;

        @JsonProperty("healthLabels")
        public String healthLabels;

        @JsonProperty("nutrients")
        public String nutrients;

        @JsonProperty("picture")
        public String picture;

    }
}
