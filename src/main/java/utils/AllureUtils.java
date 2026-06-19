package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Allure;
import io.restassured.response.Response;

public class AllureUtils {

    public static void attachResponse(Response response) {
        Allure.addAttachment(
                "Response Body",
                response.asPrettyString()
        );
    }

    public static void attachRequest(Object request) {

        try {
            // If it's already a JSON string → attach directly
            if (request instanceof String) {
                Allure.addAttachment("Request Body", (String) request);
                return;
            }

            // If it's an object → convert to pretty JSON
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(request);

            Allure.addAttachment("Request Body", json);

        } catch (Exception e) {
            Allure.addAttachment("Request Body", request.toString());
        }
    }

    public static void attachStatusCode(Response response) {
        if (response != null) {
            Allure.addAttachment(
                    "Status Code",
                    String.valueOf(response.getStatusCode())
            );
        }
    }

}
