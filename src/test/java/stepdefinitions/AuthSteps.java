package stepdefinitions;

import context.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import services.AuthService;
import validators.AuthValidator;

public class AuthSteps {

    private final ScenarioContext context =
            new ScenarioContext();

    private final AuthService authService =
            new AuthService();

    private final AuthValidator validator =
            new AuthValidator();

    @When("I login with valid credentials")
    public void login() {

        context.setResponse(
                authService.login(
                        "johnd",
                        "m38rmF$"
                )
        );
    }

    @Then("login should be successful")
    public void verifyLogin() {

        validator.verifyStatusCode(
                context.getResponse());

        validator.verifyTokenExists(
                context.getResponse());

        validator.verifyContentType(
                context.getResponse());

        validator.verifyResponseTime(
                context.getResponse());
    }
}
