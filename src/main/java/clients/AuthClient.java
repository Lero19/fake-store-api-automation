package clients;

import io.restassured.response.Response;
import models.request.LoginRequest;

public class AuthClient extends BaseApiClient {

    public Response login(LoginRequest request){

        return requestSpec()
                .body(request)
                .when()
                .post("/auth/login");
    }
}