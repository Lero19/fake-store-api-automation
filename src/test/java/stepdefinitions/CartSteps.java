package stepdefinitions;

import context.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import services.CartService;
import utils.AllureUtils;
import validators.CartValidator;

public class CartSteps {

    private final ScenarioContext context = new ScenarioContext();
    private final CartService cartService = new CartService();
    private final CartValidator validator = new CartValidator();

    @When("I request all carts")
    public void getAllCarts() {
        Allure.step("Requesting all carts");
        Response response = cartService.getAllCarts();
        context.setResponse(response);
        AllureUtils.attachResponse(response);
    }

    @When("I request cart with id {int}")
    public void getCartById(int id) {
        Response response = cartService.getCartById(id);
        context.setResponse(response);
        AllureUtils.attachResponse(response);
    }
    @Then("response should contain list of carts")
    public void verifyAllCarts() {
        validator.verifyAllCarts(context.getResponse());
    }

    @Then("response should contain cart with id {int}")
    public void verifyCart(int id) {
        validator.verifySingleCart(context.getResponse(), id);
    }

    @When("I create a new cart")
    public void createCart() {
        Allure.step("Creating a new cart");
        Response response = cartService.createCart();
        context.setResponse(response);
        AllureUtils.attachResponse(response);

    }

    @Then("cart should be created successfully")
    public void verifyCartCreated() {
        Allure.step("Validating cart creation response");
        validator.verifyCartCreated(context.getResponse());
    }
    @When("I update cart with id {int}")
    public void updateCart(int id) {
        Response response = cartService.updateCart(id);
        context.setResponse(response);
        AllureUtils.attachResponse(response);
    }

    @Then("cart should be updated successfully")
    public void verifyCartUpdated() {
        validator.verifyCartUpdated(context.getResponse());
    }

    @When("I delete cart with id {int}")
    public void deleteCart(int id) {
        Allure.step("Deleting cart with id: " + id);
        Response response = cartService.deleteCart(id);
        context.setResponse(response);
        AllureUtils.attachResponse(response);
    }

    @Then("cart should be deleted successfully")
    public void verifyCartDeleted() {
        validator.verifyCartDeleted(context.getResponse());
    }
}