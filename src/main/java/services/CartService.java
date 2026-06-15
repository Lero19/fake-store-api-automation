package services;

import clients.CartClient;
import io.restassured.response.Response;
import models.request.CreateCartRequest;

import java.util.List;

public class CartService {

    private final CartClient cartClient = new CartClient();

    public Response getAllCarts() {
        return cartClient.getAllCarts();
    }

    public Response getCartById(int id) {
        return cartClient.getCartById(id);
    }
    public Response createCart() {

        List<CreateCartRequest.Product> products = List.of(
                new CreateCartRequest.Product(1, 2),
                new CreateCartRequest.Product(2, 3)
        );
        CreateCartRequest request = new CreateCartRequest(1, "2026-06-15", products);
        return cartClient.createCart(request);
    }
    public Response updateCart(int id) {

        List<CreateCartRequest.Product> products = List.of(
                new CreateCartRequest.Product(1, 10),
                new CreateCartRequest.Product(2, 1)
        );

        CreateCartRequest request = new CreateCartRequest(id, "2026-06-15", products);
        return cartClient.updateCart(id, request);
    }
    public Response deleteCart(int id) {
        return cartClient.deleteCart(id);
    }
}

