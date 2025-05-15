package com.lanchonete.api.adapters.DTO;

import com.lanchonete.api.core.model.models.Enum.ProductCategory;
import jakarta.validation.constraints.NotNull;

public record DadosUpdateProduct(

        @NotNull
        Long id,
        String name,
        Double price,
        ProductCategory category,
        String description) {
}
