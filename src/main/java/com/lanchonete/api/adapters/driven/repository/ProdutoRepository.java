package com.lanchonete.api.adapters.driven.repository;

import com.lanchonete.api.core.model.models.Enum.Categoria;
import com.lanchonete.api.core.model.models.Produto;
import com.lanchonete.api.core.portas.repository.ProdutoRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ProdutoRepository implements ProdutoRepositoryPort {

    private final SpringProdutoRepository springProdutoRepository;

    public ProdutoRepository(SpringProdutoRepository springProdutoRepository)
    {
        this.springProdutoRepository = springProdutoRepository;
    }

    @Override
    public void save(Produto produto) {
       this.springProdutoRepository.save(produto);
    }

    @Override
    public Produto getReferenceById(long id) {
        return this.springProdutoRepository.getReferenceById(id);
    }

    @Override
    public Page<Produto> findAllByAtivoTrue(Pageable paginacao) {

        return this.springProdutoRepository.findAllByAtivoTrue(paginacao);
    }

    @Override
    public Page<Produto> findAllByCategoriaAndAtivo(Pageable paginacao, Categoria categoria) {
        System.out.println(categoria);
        return this.springProdutoRepository.findAllByCategoriaAndAtivo(categoria,true,paginacao);
    }


}
