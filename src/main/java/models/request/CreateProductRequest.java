package models.request;

public class CreateProductRequest {

    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

    public CreateProductRequest(String title,
                                double price,
                                String description,
                                String image,
                                String category) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
    }

    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public String getImage() { return image; }
    public String getCategory() { return category; }
}