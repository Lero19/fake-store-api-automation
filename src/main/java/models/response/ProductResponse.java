package models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponse {

    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

    public int getId() { return id; }
    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public String getImage() { return image; }
}
