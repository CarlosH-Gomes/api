package com.lanchonete.api.adapters.domains.produto;

import com.lanchonete.api.core.model.models.Enum.ProductCategory;
import com.lanchonete.api.core.model.models.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductForm(

        Long id,

        @NotBlank
        String name,

        @NotNull
        ProductCategory category,

        @NotNull
        Double price,

        @NotBlank
        String description) {

        public ProductForm(Product product){
                this(product.getId(), product.getName(), product.getCategory(), product.getPrice(), product.getDescription());
        }
}
