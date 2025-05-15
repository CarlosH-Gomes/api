package com.lanchonete.api.adapters.domains.produto;

import com.lanchonete.api.core.model.models.Enum.ProductCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateProductForm(

        @NotBlank
        String name,

        @NotNull
        ProductCategory category,

        @NotNull
        Double price,

        @NotBlank
        String description) {
}
