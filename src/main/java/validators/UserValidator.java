package validators;

import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class UserValidator {

    public void verifyStatusCode(Response response, int expectedStatus) {
        assertThat(response.statusCode()).isEqualTo(expectedStatus);
    }

    public void verifyUsersList(Response response) {
        assertThat(response.jsonPath().getList("$").size())
                .isGreaterThan(0);

        // optional deeper validation
        assertThat(response.jsonPath().getList("id")).isNotEmpty();
    }
}
