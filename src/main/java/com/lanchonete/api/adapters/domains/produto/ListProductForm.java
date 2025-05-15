package com.lanchonete.api.adapters.domains.produto;

import com.lanchonete.api.core.model.models.Enum.ProductCategory;
import com.lanchonete.api.core.model.models.Product;

public record ListProductForm(Long id, String name, ProductCategory category, Double price, String description) {

    public ListProductForm(Product product){
        this(product.getId(), product.getName(), product.getCategory(), product.getPrice(), product.getDescription());
    }
}
