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

    // GET USERS
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

    // CREATE USER
    @When("I create a new user")
    public void createUser() {
        context.setResponse(
                userService.createUser(
                        "testuser",
                        "test@mail.com",
                        "password123"
                )
        );
    }

    @Then("user should be created successfully")
    public void verifyUserCreated() {
        validator.verifyUserCreated(context.getResponse());
    }
    @When("I request user with id {int}")
    public void getUserById(int id) {
        context.setResponse(userService.getUserById(id));
    }

    @Then("response should contain user with id {int}")
    public void verifySingleUser(int id) {
        validator.verifySingleUser(context.getResponse(), id);
    }

    @When("I update user with id {int}")
    public void updateUser(int id) {

        context.setResponse(
                userService.updateUser(
                        id,
                        "updatedUser",
                        "updated@mail.com",
                        "newPassword123"
                )
        );
    }

    @Then("user should be updated with id {int}")
    public void verifyUserUpdated(int id) {
        validator.verifyUserUpdated(context.getResponse());
    }
    @When("I delete user with id {int}")
    public void deleteUser(int id) {
        context.setResponse(userService.deleteUser(id));
    }

    @Then("user should be deleted successfully")
    public void verifyUserDeleted() {
        validator.verifyUserDeleted(context.getResponse());
    }
    @When("I request user with invalid id")
    public void getUserInvalid() {
        context.setResponse(userService.getUserById(9999));
    }
}
