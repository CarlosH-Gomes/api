package com.lanchonete.api.adapters.domains.produto;

import com.lanchonete.api.core.model.models.Enum.ProductCategory;

public class ProductDTO {

    private Long id;
    private ProductCategory category;
    private String name;
    private Double price;
    private String description;
    private Boolean active;

    public ProductDTO(Long id, ProductCategory category, String name, Double price, String description, Boolean active) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.description = description;
        this.active = active;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
