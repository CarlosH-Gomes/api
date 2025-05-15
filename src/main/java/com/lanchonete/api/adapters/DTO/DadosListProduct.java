package com.lanchonete.api.adapters.DTO;

import com.lanchonete.api.core.model.models.Enum.ProductCategory;
import com.lanchonete.api.core.model.models.Product;

public record DadosListProduct(Long id, String name, ProductCategory category, Double price, String description) {

    public DadosListProduct(Product product){
        this(product.getId(), product.getName(), product.getCategory(), product.getPrice(), product.getDescription());
    }
}
