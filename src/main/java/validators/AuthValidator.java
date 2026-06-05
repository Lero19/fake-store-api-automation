package validators;

import io.restassured.response.Response;
import models.response.LoginResponse;
import org.assertj.core.api.Assertions;

public class AuthValidator {

    public void verifyStatusCode(Response response){

        Assertions.assertThat(response.statusCode())
                .isEqualTo(201);
    }

    public void verifyTokenExists(Response response){

        LoginResponse loginResponse =
                response.as(LoginResponse.class);

        Assertions.assertThat(loginResponse.getToken())
                .isNotNull()
                .isNotBlank();
    }

    public void verifyResponseTime(Response response){

        Assertions.assertThat(response.time())
                .isLessThan(3000);
    }

    public void verifyContentType(Response response){

        Assertions.assertThat(
                        response.contentType())
                .contains("application/json");
    }
}