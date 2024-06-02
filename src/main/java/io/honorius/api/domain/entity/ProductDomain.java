package io.honorius.api.domain.entity;

import io.honorius.api.enums.ProductCategory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class ProductDomain {

    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    private String description;
    private Double price;
    private Integer stock;
    private String image;

    public ProductDomain() {
    }

    public ProductDomain(Integer id, String name, ProductCategory category, String description, Double price, Integer stock, String image) {
        this.id = id;
        this.name = name;
        this.category = (category == null || category.equals("")) ? ProductCategory.NOT_DEFINED : category;
        this.description = (description == null || description.trim().isEmpty()) ? "Description does not register" : description;
        this.price = price;
        this.stock = stock;
        this.image = (image == null || image.trim().isEmpty()) ? "No reference image" : image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", image='" + image + '\'' +
                '}';
    }
}
