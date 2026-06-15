package services;

import clients.ProductClient;
import io.restassured.response.Response;
import models.request.CreateProductRequest;

public class ProductService {

    private final ProductClient productClient = new ProductClient();

    public Response getAllProducts() {
        return productClient.getAllProducts();
    }

    public Response getProductById(int id) {
        return productClient.getProductById(id);
    }

    public Response createProduct() {

        CreateProductRequest request =
                new CreateProductRequest(
                        "Test Product",
                        99.99,
                        "Test description",
                        "http://example.com",
                        "electronics"
                );

        return productClient.createProduct(request);
    }
    public Response updateProduct(int id) {

        CreateProductRequest request =
                new CreateProductRequest(
                        "Updated Product",
                        120.50,
                        "Updated description",
                        "http://example.com",
                        "electronics"
                );

        return productClient.updateProduct(id, request);
    }
    public Response deleteProduct(int id) {
        return productClient.deleteProduct(id);
    }
}