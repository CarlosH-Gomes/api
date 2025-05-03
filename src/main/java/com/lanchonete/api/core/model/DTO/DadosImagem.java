package com.lanchonete.api.core.model.DTO;

import jakarta.validation.constraints.NotBlank;

public record DadosImagem(

        @NotBlank
        String link_imagem) {
}
