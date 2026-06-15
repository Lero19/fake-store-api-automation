package validators;

import io.restassured.response.Response;
import models.response.CreateUserResponse;
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
}
