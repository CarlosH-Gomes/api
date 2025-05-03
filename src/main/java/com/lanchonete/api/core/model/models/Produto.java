package com.lanchonete.api.core.model.models;

import com.lanchonete.api.core.model.DTO.DadosAtualizaProduto;
import com.lanchonete.api.core.model.DTO.DadosCadastroProduto;
import com.lanchonete.api.core.model.models.Enum.Categoria;
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
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
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

    public void atualizarInformacoes(DadosAtualizaProduto dados,String imagemUrl) {
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
