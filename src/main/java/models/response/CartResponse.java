package models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartResponse {

    private int id;
    private int userId;
    private String date;
    private List<Product> products;

    public int getId() { return id; }

    public int getUserId() { return userId; }

    public String getDate() { return date; }

    public List<Product> getProducts() { return products; }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Product {

        private int productId;
        private int quantity;

        public int getProductId() { return productId; }
        public int getQuantity() { return quantity; }
    }
}