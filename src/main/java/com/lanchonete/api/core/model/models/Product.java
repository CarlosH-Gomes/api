package com.lanchonete.api.core.model.models;

import com.lanchonete.api.adapters.domains.produto.UpdateProductForm;
import com.lanchonete.api.adapters.domains.produto.CreateProductForm;
import com.lanchonete.api.core.model.models.Enum.ProductCategory;


public class Product {

    private Long id;
    private ProductCategory category;
    private String name;
    private Double price;
    private String description;
    private Boolean active;

    public Product(CreateProductForm dados) {

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

    public void updateProduto(UpdateProductForm updateProductForm) {
        
        if(updateProductForm.name() != null){
            this.name = updateProductForm.name();
        }
        if(updateProductForm.price() != null){
            this.price = updateProductForm.price();
        }
        if(updateProductForm.category() != null){
            this.category = updateProductForm.category();
        }
        if(updateProductForm.description() != null){
            this.description = updateProductForm.description();
        }

    }

    public void setActiveFalse() {
        this.active = false;
    }

}
