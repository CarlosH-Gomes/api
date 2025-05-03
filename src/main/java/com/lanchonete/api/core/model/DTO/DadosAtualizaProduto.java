package com.lanchonete.api.core.model.DTO;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record DadosAtualizaProduto(

        @NotNull
        Long id,
        String nome,
        Double preco,
        String descricao,
        MultipartFile link_imagem) {
}
