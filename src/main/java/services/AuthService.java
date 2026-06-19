package services;

import clients.AuthClient;
import config.ConfigReader;
import io.restassured.response.Response;
import models.request.LoginRequest;
import utils.AllureUtils;
import utils.FileUtils;

import static io.restassured.RestAssured.given;

public class AuthService {

    private final AuthClient authClient = new AuthClient();

//    public Response login(String username,String password){
//
//        LoginRequest request =
//                new LoginRequest(username,password);
//
//        return authClient.login(request);
//    }
public Response login() {

    String payload = FileUtils.readFile(
            "src/main/resources/payloads/authentication/authentication.json"
    );

    AllureUtils.attachRequest(payload);

    Response response = given()
            .baseUri(ConfigReader.getBaseUrl())
            .header("Content-Type", "application/json")
            .body(payload)
            .when()
            .post("/auth/login");

    AllureUtils.attachResponse(response);
    AllureUtils.attachStatusCode(response);

    return response;
}
}