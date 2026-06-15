package clients;

import io.restassured.response.Response;
import models.request.CreateProductRequest;

public class ProductClient extends BaseApiClient {

    public Response getAllProducts() {
        return requestSpec().when().get("/products");
    }

    public Response getProductById(int id) {
        return requestSpec()
                .pathParam("id", id)
                .when()
                .get("/products/{id}");
    }

    public Response createProduct(CreateProductRequest request) {
        return requestSpec()
                .body(request)
                .when()
                .post("/products");
    }

    public Response updateProduct(int id, CreateProductRequest request) {
        return requestSpec()
                .pathParam("id", id)
                .body(request)
                .when()
                .put("/products/{id}");
    }

    public Response deleteProduct(int id) {
        return requestSpec()
                .pathParam("id", id)
                .when()
                .delete("/products/{id}");
    }
}