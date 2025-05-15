package com.lanchonete.api.adapters.DTO;

import jakarta.validation.constraints.NotNull;

public record DadosUpdateProduct(

        @NotNull
        Long id,
        String name,
        Double price,
        String description) {
}
