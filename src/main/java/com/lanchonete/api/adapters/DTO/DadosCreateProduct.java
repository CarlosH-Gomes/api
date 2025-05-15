package com.lanchonete.api.adapters.DTO;

import com.lanchonete.api.core.model.models.Enum.ProductCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCreateProduct(

        @NotBlank
        String name,

        @NotNull
        ProductCategory category,

        @NotNull
        Double price,

        @NotBlank
        String description) {
}
