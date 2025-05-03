package com.lanchonete.api.core.model.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Imagem {

    private String link_imagem;

    public Imagem(String imagem) {
        this.link_imagem = imagem;
    }

    public void atualzarInformacoes(String imagem) {
        if(imagem != null){
            this.link_imagem = imagem;
        }
    }
}
