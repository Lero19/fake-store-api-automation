package clients;

import io.restassured.response.Response;
import models.request.CreateUserRequest;

public class UserClient extends BaseApiClient {

    public Response getAllUsers() {

        return requestSpec()
                .when()
                .get("/users");
    }
    public Response createUser(CreateUserRequest request) {

        return requestSpec()
                .body(request)
                .when()
                .post("/users");
    }
    public Response getUserById(int id) {

        return requestSpec()
                .pathParam("id", id)
                .when()
                .get("/users/{id}");
    }
}
