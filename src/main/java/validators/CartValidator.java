package validators;

import io.restassured.response.Response;
import models.response.CartResponse;
import org.assertj.core.api.Assertions;

import java.util.List;

public class CartValidator {

    public void verifyAllCarts(Response response) {

        List<Object> carts = response.jsonPath().getList("$");
        Assertions.assertThat(carts)
                .isNotNull()
                .isNotEmpty();

        Assertions.assertThat(carts.size()).isGreaterThan(0); // extra safety
    }
    public void verifySingleCart(Response response, int expectedId) {

        CartResponse cart = response.as(CartResponse.class);

        Assertions.assertThat(cart.getId()).isEqualTo(expectedId);
        Assertions.assertThat(cart.getUserId()).isGreaterThan(0);
        Assertions.assertThat(cart.getDate()).isNotBlank();
        Assertions.assertThat(cart.getProducts()).isNotNull().isNotEmpty();

        // validate product content
        CartResponse.Product firstProduct = cart.getProducts().get(0);

        Assertions.assertThat(firstProduct.getProductId()).isGreaterThan(0);
        Assertions.assertThat(firstProduct.getQuantity()).isGreaterThan(0);
    }
    public void verifyCartCreated(Response response) {

        Assertions.assertThat(response.jsonPath().getInt("id")).isGreaterThanOrEqualTo(0);
        Assertions.assertThat(response.jsonPath().getInt("userId")).isGreaterThan(0);
    }
    public void verifyCartUpdated(Response response) {

        Assertions.assertThat(response.jsonPath().getInt("id")).isGreaterThanOrEqualTo(0);
        Assertions.assertThat(response.jsonPath().getList("products")).isNotNull().isNotEmpty();
    }
    public void verifyCartDeleted(Response response) {
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.time()).isLessThan(3000);
    }
}
