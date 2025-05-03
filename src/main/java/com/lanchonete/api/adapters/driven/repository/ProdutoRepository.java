package com.lanchonete.api.adapters.driven.repository;

import com.lanchonete.api.core.model.models.Produto;
import com.lanchonete.api.core.portas.repository.ProdutoRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProdutoRepository implements ProdutoRepositoryPort {
    public Page<Produto> findAllByAtivoTrue(Pageable paginacao) {
        return null;
    }
}
