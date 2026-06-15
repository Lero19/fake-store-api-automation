package models.request;

import java.util.List;

public class CreateCartRequest {

    private int userId;
    private String date;
    private List<Product> products;

    public CreateCartRequest(int userId, String date, List<Product> products) {
        this.userId = userId;
        this.date = date;
        this.products = products;
    }

    // ✅ ADD THESE GETTERS
    public int getUserId() {
        return userId;
    }

    public String getDate() {
        return date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public static class Product {
        private int productId;
        private int quantity;

        public Product(int productId, int quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }

        public int getProductId() {
            return productId;
        }
        public int getQuantity() {
            return quantity;
        }
    }
}
