package services;

import clients.UserClient;
import io.restassured.response.Response;
import models.request.CreateUserRequest;

public class UserService {

    private final UserClient userClient = new UserClient();

    public Response getAllUsers() {
        return userClient.getAllUsers();
    }

    public Response createUser(String username, String email, String password) {

        CreateUserRequest request = new CreateUserRequest(username, email, password);
        return userClient.createUser(request);
    }
    public Response getUserById(int id) {
        return userClient.getUserById(id);
    }
}
