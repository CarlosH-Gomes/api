package com.lanchonete.api.adapters.driven.repository;

import com.lanchonete.api.adapters.driven.entity.ProdutoEntity;
import com.lanchonete.api.core.model.models.Enum.Categoria;
import com.lanchonete.api.core.model.models.Produto;
import com.lanchonete.api.core.portas.repository.ProdutoRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProdutoRepository implements ProdutoRepositoryPort {

    private final SpringProdutoRepository springProdutoRepository;

    public ProdutoRepository(SpringProdutoRepository springProdutoRepository)
    {
        this.springProdutoRepository = springProdutoRepository;
    }

    @Override
    public void save(Produto produto) {

        ProdutoEntity produtoEntity =  new ProdutoEntity(produto);
        if (Objects.isNull(produto.getId()))
            produtoEntity = new ProdutoEntity(produto);
        else {
            produtoEntity = this.springProdutoRepository.findById(produto.getId()).get();
            produtoEntity.atualizar(produto);
        }
        this.springProdutoRepository.save(produtoEntity);
    }

    @Override
    public Produto getReferenceById(long id) {
        ProdutoEntity produtoEntity =  this.springProdutoRepository.getReferenceById(id);
        return produtoEntity.toProduto();
    }

    @Override
    public Page<Produto> findAllByAtivoTrue(Pageable paginacao) {
        Page<ProdutoEntity> produtoEntity = this.springProdutoRepository.findAllByAtivoTrue(paginacao);
        Page<Produto> produtos = produtoEntity.map(ProdutoEntity::toProduto);
        return produtos;
    }

    @Override
    public Page<Produto> findAllByCategoriaAndAtivo(Pageable paginacao, Categoria categoria) {
        Page<ProdutoEntity> produtoEntity =this.springProdutoRepository.findAllByCategoriaAndAtivo(categoria,true,paginacao);
        Page<Produto> produtos = produtoEntity.map(ProdutoEntity::toProduto);
        return produtos;
    }


}
