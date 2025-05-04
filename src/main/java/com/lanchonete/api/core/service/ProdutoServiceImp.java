package com.lanchonete.api.core.service;

import com.lanchonete.api.core.model.DTO.DadosAtualizaProduto;
import com.lanchonete.api.core.model.DTO.DadosCadastroProduto;
import com.lanchonete.api.core.model.DTO.DadosListagemProduto;
import com.lanchonete.api.core.model.models.Enum.Categoria;
import com.lanchonete.api.core.model.models.Produto;
import com.lanchonete.api.core.portas.repository.ProdutoRepositoryPort;
import com.lanchonete.api.core.portas.service.ProdutoServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public class ProdutoServiceImp implements ProdutoServicePort {


    private ProdutoRepositoryPort repository;

    public ProdutoServiceImp(ProdutoRepositoryPort produtoRepositoryPort) {
        this.repository = produtoRepositoryPort;
    }

    //@Autowired
    //private StorageFileService storageFileService;

    @Override
    public void salvar(DadosCadastroProduto dados) {

       // String imagemUrl = storageFileService.uploadFile(dados.link_imagem() , dados.nome() ,"produtoImagem");

        Produto produto = new Produto(dados);

       // produto.addUrl(imagemUrl);
        repository.save(produto);
    }

    @Override
    public void atualizar(DadosAtualizaProduto dados) {
        var produto = repository.getReferenceById(dados.id());
        String imagemUrl = null; // storageFileService.uploadFile(dados.link_imagem() , dados.nome() ,"produtoImagem");

        System.out.println(produto.getAtivo());

        produto.atualizarInformacoes(dados,imagemUrl);
        repository.save(produto);
    }

    @Override
    public void deletar(Long id) {
        var produto = repository.getReferenceById(id);
        produto.excluir();
        System.out.println(produto.getAtivo());
        repository.save(produto);
    }

    @Override
    public Page<DadosListagemProduto> recuperar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemProduto::new);
    }

    @Override
    public Page<DadosListagemProduto> recuperar(Pageable paginacao, Categoria categoria) {
        return repository.findAllByCategoriaAndAtivo(paginacao,categoria).map(DadosListagemProduto::new);
    }
}
