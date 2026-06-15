package stepdefinitions;

import context.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import services.ProductService;
import validators.ProductValidator;

public class ProductSteps {

    private final ScenarioContext context;
    private final ProductService productService = new ProductService();
    private final ProductValidator validator = new ProductValidator();

    public ProductSteps(ScenarioContext context) {
        this.context = context;
    }

    // ✅ GET ALL PRODUCTS
    @When("I request all products")
    public void getAllProducts() {
        context.setResponse(productService.getAllProducts());
    }

    @Then("response should contain list of products")
    public void verifyAllProducts() {
        validator.verifyProductList(context.getResponse());
    }

    // ✅ GET PRODUCT BY ID
    @When("I request product with id {int}")
    public void getProductById(int id) {
        context.setResponse(productService.getProductById(id));
    }

    @Then("response should contain product with id {int}")
    public void verifySingleProduct(int id) {
        validator.verifySingleProduct(context.getResponse(), id);
    }

    // ✅ CREATE PRODUCT
    @When("I create a new product")
    public void createProduct() {
        context.setResponse(productService.createProduct());
    }

    @Then("product should be created successfully")
    public void verifyProductCreated() {
        validator.verifyProductCreated(context.getResponse());
    }

    // UPDATE PRODUCT
    @When("I update product with id {int}")
    public void updateProduct(int id) {
        context.setResponse(productService.updateProduct(id));
    }

    @Then("product should be updated successfully")
    public void verifyProductUpdated() {
        validator.verifyProductUpdated(context.getResponse());
    }

    // DELETE PRODUCT
    @When("I delete product with id {int}")
    public void deleteProduct(int id) {
        context.setResponse(productService.deleteProduct(id));
    }

    @Then("product should be deleted successfully")
    public void verifyProductDeleted() {
        // simple validation (FakeStore limitation)
        context.getResponse().then().statusCode(200);
    }
}