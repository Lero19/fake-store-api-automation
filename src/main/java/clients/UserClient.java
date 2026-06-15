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
    public Response updateUser(int id, CreateUserRequest request) {

        return requestSpec()
                .pathParam("id", id)
                .body(request)
                .when()
                .put("/users/{id}");
    }
    public Response deleteUser(int id) {

        return requestSpec()
                .pathParam("id", id)
                .when()
                .delete("/users/{id}");
    }
}
