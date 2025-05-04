package com.lanchonete.api.core.portas.service;

import com.lanchonete.api.core.model.DTO.DadosAtualizaProduto;
import com.lanchonete.api.core.model.DTO.DadosCadastroProduto;
import com.lanchonete.api.core.model.DTO.DadosListagemProduto;
import com.lanchonete.api.core.model.models.Enum.Categoria;
import com.lanchonete.api.core.model.models.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoServicePort {

     void salvar(DadosCadastroProduto dados);
     void atualizar(DadosAtualizaProduto dados);
     void deletar(Long id);

     //polimorfismo
     Page<DadosListagemProduto> recuperar(Pageable paginacao);
     Page<DadosListagemProduto> recuperar(Pageable paginacao, Categoria categoria);
}
