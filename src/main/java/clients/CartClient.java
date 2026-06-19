package clients;

import config.ConfigReader;
import io.restassured.response.Response;
import models.request.CreateCartRequest;
import utils.AllureUtils;

import static io.restassured.RestAssured.given;

public class CartClient {

    // GET ALL CARTS
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

    // GET CART BY ID
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

    // CREATE CART
    public Response createCart(String payload) {

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

    // UPDATE CART
    public Response updateCart(int id, CreateCartRequest request) {

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

    // DELETE CART BY ID
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