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

    //private final ScenarioContext context = new ScenarioContext();
    private final ScenarioContext context;
    private final CartService cartService = new CartService();
    private final CartValidator validator = new CartValidator();


    public CartSteps(ScenarioContext context) {
        this.context = context;
    }


    @When("I request all carts")
    public void getAllCarts() {
        context.setResponse(cartService.getAllCarts());
    }

    @When("I request cart with id {int}")
    public void getCartById(int id) {
        context.setResponse(cartService.getCartById(id));
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
        context.setResponse(cartService.updateCart(id));
    }

    @Then("cart should be updated successfully")
    public void verifyCartUpdated() {
        validator.verifyCartUpdated(context.getResponse());
    }
    @When("I delete cart with id {int}")
    public void deleteCart(int id) {
        context.setResponse(cartService.deleteCart(id));
    }

    @Then("cart should be deleted successfully")
    public void verifyCartDeleted() {
        validator.verifyCartDeleted(context.getResponse());
    }
}