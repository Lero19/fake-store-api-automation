package validators;

import io.restassured.response.Response;
import models.response.CreateUserResponse;
import models.response.UpdateUserResponse;
import models.response.UserResponse;
import org.assertj.core.api.Assertions;

import java.util.List;

public class UserValidator {

    public void verifyStatusCode(Response response, int expectedStatusCode) {
        Assertions.assertThat(response.statusCode())
                .isEqualTo(expectedStatusCode);
    }

    public void verifyUsersList(Response response) {

        List<Object> users = response.jsonPath().getList("$");

        Assertions.assertThat(users)
                .isNotNull()
                .isNotEmpty();
    }

    public void verifyUserCreated(Response response) {
        CreateUserResponse user = response.as(CreateUserResponse.class);
        Assertions.assertThat(user.getId()).isGreaterThanOrEqualTo(0);
    }
    public void verifySingleUser(Response response, int expectedId) {

        UserResponse user = response.as(UserResponse.class);

        Assertions.assertThat(user.getId()).isEqualTo(expectedId);
        Assertions.assertThat(user.getUsername()).isNotBlank();
        Assertions.assertThat(user.getEmail()).isNotBlank();
    }
    public void verifyUserUpdated(Response response) {

        UpdateUserResponse user = response.as(UpdateUserResponse.class);

        Assertions.assertThat(user.getUsername()).isEqualTo("updatedUser");
        Assertions.assertThat(user.getEmail()).isEqualTo("updated@mail.com");
    }
    public void verifyUserDeleted(Response response) {

        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.time()).isLessThan(3000);
    }
    public void verifyErrorResponse(Response response) {
        Assertions.assertThat(response.statusCode()).isIn(400, 401, 404);
        Assertions.assertThat(response.asString()).isNotEmpty();
    }
}
