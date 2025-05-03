package com.lanchonete.api.core.portas.service;

import com.lanchonete.api.core.model.DTO.DadosAtualizaProduto;
import com.lanchonete.api.core.model.DTO.DadosCadastroProduto;
import com.lanchonete.api.core.model.DTO.DadosListagemProduto;
import com.lanchonete.api.core.model.models.Enum.Categoria;
import com.lanchonete.api.core.model.models.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoServicePort {

    public void salvar(DadosCadastroProduto dados);
    public Page<DadosListagemProduto> recuperar(Pageable paginacao);
    public Page<DadosListagemProduto> recuperar(Pageable paginacao, Categoria categoria);
    public void atualizar(DadosAtualizaProduto dados);
    public void deletar(Long id);
}
