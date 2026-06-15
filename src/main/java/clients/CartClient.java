package clients;

import io.restassured.response.Response;
import models.request.CreateCartRequest;

public class CartClient extends BaseApiClient {

    public Response getAllCarts() {

        return requestSpec()
                .when()
                .get("/carts");
    }

    public Response getCartById(int id) {

        return requestSpec()
                .pathParam("id", id)
                .when()
                .get("/carts/{id}");
    }

    public Response createCart(CreateCartRequest request) {

        return requestSpec()
                .body(request)
                .when()
                .post("/carts");
    }
    public Response updateCart(int id, CreateCartRequest request) {

        return requestSpec()
                .pathParam("id", id)
                .body(request)
                .when()
                .put("/carts/{id}");
    }
    public Response deleteCart(int id) {

        return requestSpec()
                .pathParam("id", id)
                .when()
                .delete("/carts/{id}");
    }
}