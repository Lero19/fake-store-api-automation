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

        logger.info("Sending POST request to create cart...");
        logger.info("Request Body: {}", request);

        Response response = requestSpec()
                .body(request)
                .when()
                .post("/carts");

        logger.info("Response Status: {}", response.statusCode());
        return response;
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