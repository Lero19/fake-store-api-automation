package stepdefinitions;

import context.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import services.UserService;
import validators.UserValidator;

public class UserSteps {

    private final ScenarioContext context = new ScenarioContext();
    private final UserService userService = new UserService();
    private final UserValidator validator = new UserValidator();

    @When("I request all users")
    public void getAllUsers() {
        context.setResponse(userService.getAllUsers());
    }

    @Then("response status should be {int}")
    public void verifyStatus(int statusCode) {
        validator.verifyStatusCode(context.getResponse(), statusCode);
    }

    @Then("response should contain list of users")
    public void verifyUsers() {
        validator.verifyUsersList(context.getResponse());
    }
}
