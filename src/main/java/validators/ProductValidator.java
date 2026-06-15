package validators;

import io.restassured.response.Response;
import models.response.ProductResponse;
import org.assertj.core.api.Assertions;

public class ProductValidator {

    public void verifyProductList(Response response) {
        Assertions.assertThat(response.jsonPath().getList("$"))
                .isNotEmpty();
    }
    public void verifySingleProduct(Response response, int id) {
        ProductResponse product = response.as(ProductResponse.class);

        Assertions.assertThat(product.getId()).isEqualTo(id);
        Assertions.assertThat(product.getTitle()).isNotBlank();
    }
    public void verifyProductCreated(Response response) {
        Assertions.assertThat(response.jsonPath().getInt("id"))
                .isGreaterThan(0);
    }
    public void verifyProductUpdated(Response response) {
        Assertions.assertThat(response.jsonPath().getString("title"))
                .isNotBlank();
    }
}