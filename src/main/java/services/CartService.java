package services;

import clients.CartClient;
import config.ConfigReader;
import io.restassured.response.Response;
import models.request.CreateCartRequest;
import utils.AllureUtils;
import utils.FileUtils;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CartService {

    private final CartClient cartClient = new CartClient();

    public Response getAllCarts() {

        AllureUtils.attachRequest("GET /carts");

        Response response = given()
                .baseUri(ConfigReader.getBaseUrl())
                .when()
                .get("/carts");

        AllureUtils.attachResponse(response);
        AllureUtils.attachStatusCode(response);

        return response;
    }

    public Response getCartById(int id) {

        AllureUtils.attachRequest("GET /carts/" + id);

        Response response = given()
                .baseUri(ConfigReader.getBaseUrl())
                .when()
                .get("/carts/" + id);

        AllureUtils.attachResponse(response);
        AllureUtils.attachStatusCode(response);

        return response;
    }

    public Response createCart() {

        String payload = FileUtils.readFile("src/main/resources/payloads.cartManagement/createCart.json");

        AllureUtils.attachRequest(payload);

        Response response = given()
                .baseUri(ConfigReader.getBaseUrl())
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/carts");

        AllureUtils.attachResponse(response);
        AllureUtils.attachStatusCode(response);

        return response;
    }
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

        AllureUtils.attachRequest(request);

        Response response = given()
                .baseUri(ConfigReader.getBaseUrl())
                .header("Content-Type", "application/json")
                .body(request)
                .when()
                .put("/carts/" + id);

        AllureUtils.attachResponse(response);
        AllureUtils.attachStatusCode(response);

        return response;
    }
    public Response deleteCart(int id) {

        AllureUtils.attachRequest("DELETE /carts/" + id);

        Response response = given()
                .baseUri(ConfigReader.getBaseUrl())
                .when()
                .delete("/carts/" + id);

        AllureUtils.attachResponse(response);
        AllureUtils.attachStatusCode(response);

        return response;
    }
}

