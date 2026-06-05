package clients;

import config.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseApiClient {

    protected RequestSpecification requestSpec() {

        return RestAssured.given()
                .baseUri(ConfigReader.getBaseUrl())
                .header("Content-Type","application/json")
                .log().all();
    }
}