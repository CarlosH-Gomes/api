package com.lanchonete.api.adapters.domains.produto;

import com.lanchonete.api.core.model.models.Enum.ProductCategory;
import jakarta.validation.constraints.NotNull;

public record UpdateProductForm(

        @NotNull
        Long id,
        String name,
        Double price,
        ProductCategory category,
        String description) {
}
