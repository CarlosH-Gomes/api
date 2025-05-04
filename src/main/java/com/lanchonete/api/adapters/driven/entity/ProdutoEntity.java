package com.lanchonete.api.adapters.driven.entity;

import com.lanchonete.api.core.model.DTO.DadosAtualizaProduto;
import com.lanchonete.api.core.model.DTO.DadosCadastroProduto;
import com.lanchonete.api.core.model.models.Enum.Categoria;
import com.lanchonete.api.core.model.models.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "produtos")
@Entity(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProdutoEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private String nome;
    private Double preco;
    private String descricao;


    private String link_imagem;

    private Boolean ativo;

    public ProdutoEntity(DadosCadastroProduto dados) {

        this.ativo = true;
        this.nome = dados.nome();
        this.categoria = dados.categoria();
        this.preco = dados.preco();
        this.descricao = dados.descricao();
    }

    public ProdutoEntity(Produto produto) {
        this.ativo = true;
        this.nome = produto.getNome();
        this.categoria =produto.getCategoria();
        this.preco = produto.getPreco();
        this.descricao = produto.getDescricao();
        this.link_imagem = produto.getLink_imagem();
    }

    public void atualizar(Produto produto)
    {

        this.ativo = produto.getAtivo();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.descricao = produto.getDescricao();
        this.link_imagem = produto.getLink_imagem();

    }

    public Produto toProduto() {
        return new Produto(this.id,this.nome,this.ativo, this.categoria, this.preco, this.descricao,this.link_imagem);
    }


}
