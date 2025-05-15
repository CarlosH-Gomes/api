package com.lanchonete.api.core.model.models;

import com.lanchonete.api.adapters.domains.produto.ProductForm;
import com.lanchonete.api.core.model.models.Enum.ProductCategory;


public class Product {

    private Long id;
    private ProductCategory category;
    private String name;
    private Double price;
    private String description;
    private Boolean active;

    public Product(ProductForm dados) {

        this.active = true;
        this.name = dados.name();
        this.category = dados.category();
        this.price = dados.price();
        this.description = dados.description();
    }

    public Product(Long id, String name, Boolean active, ProductCategory productCategory, Double price, String description) {
        this.id = id;
        this.name = name;
        this.category = productCategory;
        this.price = price;
        this.description = description;
        this.active = active;
    }



    public Long getId() {
        return id;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }


    public Boolean getActive() {
        return active;
    }

    public void updateProduto(ProductForm productForm) {
        
        if(productForm.name() != null){
            this.name = productForm.name();
        }
        if(productForm.price() != null){
            this.price = productForm.price();
        }
        if(productForm.category() != null){
            this.category = productForm.category();
        }
        if(productForm.description() != null){
            this.description = productForm.description();
        }

    }

    public void setActiveFalse() {
        this.active = false;
    }

}
