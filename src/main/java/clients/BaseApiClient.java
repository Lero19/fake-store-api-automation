package clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseApiClient {

    protected static final Logger logger =
            LogManager.getLogger(BaseApiClient.class);

    protected RequestSpecification requestSpec() {

        logger.info("Setting up base request specification...");

        return RestAssured.given()
                .baseUri("https://fakestoreapi.com")
                .contentType(ContentType.JSON);
    }
}
