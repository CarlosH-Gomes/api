package com.lanchonete.api.core.model.DTO;

import com.lanchonete.api.core.model.models.Enum.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record DadosCadastroProduto(

        @NotBlank
        String nome,

        @NotNull
        Categoria categoria,

        @NotNull
        Double preco,

        @NotBlank
        String descricao,


        MultipartFile link_imagem ) {
}
