package com.lanchonete.api.core.model.DTO;

import com.lanchonete.api.core.model.models.Enum.Categoria;
import com.lanchonete.api.core.model.models.Produto;

public record DadosListagemProduto(Long id, String nome, Categoria categoria, Double preco, String descricao, String link_imagem) {

    public DadosListagemProduto(Produto produto){
        this(produto.getId(),produto.getNome(), produto.getCategoria(), produto.getPreco(),produto.getDescricao(),produto.getLink_imagem() );
    }
}
