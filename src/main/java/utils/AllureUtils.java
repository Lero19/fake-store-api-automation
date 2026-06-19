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
