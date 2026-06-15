package utils;

import io.qameta.allure.Allure;
import io.restassured.response.Response;

public class AllureUtils {

    public static void attachResponse(Response response) {

        Allure.addAttachment(
                "Response Body",
                response.asPrettyString()
        );
    }

    public static void attachRequest(String requestBody) {

        Allure.addAttachment(
                "Request Body",
                requestBody
        );
    }
}
