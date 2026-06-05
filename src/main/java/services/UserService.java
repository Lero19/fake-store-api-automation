package services;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserService {

    private static final String BASE_URL = "https://fakestoreapi.com";

    public Response getAllUsers() {

        return given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .when()
                .get("/users")
                .then()
                .extract()
                .response();
    }
}
