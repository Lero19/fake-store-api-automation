package services;

import clients.CartClient;
import io.restassured.response.Response;
import models.request.CreateCartRequest;
import utils.FileUtils;

import java.util.List;

public class CartService {

    private final CartClient cartClient = new CartClient();

    // GET ALL CARTS
    public Response getAllCarts() {
        return cartClient.getAllCarts();
    }

    // GET CART BY ID
    public Response getCartById(int id) {
        return cartClient.getCartById(id);
    }

    // CREATE CART
    public Response createCart() {

        String payload = FileUtils.readFile("src/main/resources/payloads.cartManagement/createCart.json");

        return cartClient.createCart(payload);
    }

    // UPDATE CART
    public Response updateCart(int id) {

        List<CreateCartRequest.Product> products = List.of(
                new CreateCartRequest.Product(1, 10),
                new CreateCartRequest.Product(2, 1)
        );

        CreateCartRequest request = new CreateCartRequest(
                id,
                "2026-06-15",
                products
        );

        return cartClient.updateCart(id, request);
    }

    // DELETE CART
    public Response deleteCart(int id) {
        return cartClient.deleteCart(id);
    }
}

