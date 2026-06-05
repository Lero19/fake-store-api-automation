package services;

import clients.AuthClient;
import io.restassured.response.Response;
import models.request.LoginRequest;

public class AuthService {

    private final AuthClient authClient = new AuthClient();

    public Response login(String username,String password){

        LoginRequest request =
                new LoginRequest(username,password);

        return authClient.login(request);
    }
}