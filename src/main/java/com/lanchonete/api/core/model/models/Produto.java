package com.lanchonete.api.core.model.models;

import com.lanchonete.api.core.model.DTO.DadosAtualizaProduto;
import com.lanchonete.api.core.model.DTO.DadosCadastroProduto;
import com.lanchonete.api.core.model.models.Enum.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class Produto {

    private Long id;
    private Categoria categoria;
    private String nome;
    private Double preco;
    private String descricao;
    private String link_imagem;
    private Boolean ativo;

    public Produto(DadosCadastroProduto dados) {

        this.ativo = true;
        this.nome = dados.nome();
        this.categoria = dados.categoria();
        this.preco = dados.preco();
        this.descricao = dados.descricao();
    }

    public Produto(Long id, String nome, Categoria categoria, Double preco, String descricao, String linkImagem) {
        this.id = id;
        this.nome = nome;
        this.categoria =categoria;
        this.preco = preco;
        this.descricao = descricao;
        this.link_imagem = linkImagem;
    }



    public Long getId() {
        return id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLink_imagem() {
        return link_imagem;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void atualizarInformacoes(DadosAtualizaProduto dados, String imagemUrl) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.preco() != null){
            this.preco = dados.preco();
        }
        if(dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if(dados.link_imagem() != null){
            this.link_imagem = imagemUrl;
        }

    }


    public void excluir() {
        this.ativo = false;
    }

    public void addUrl(String imagemUrl) {
        if(imagemUrl != null){
            this.link_imagem = imagemUrl ;
        }
    }
}
