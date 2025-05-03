package com.lanchonete.api.core.portas.repository;

import com.lanchonete.api.core.model.models.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoRepositoryPort {
    Page<Produto> findAllByAtivoTrue(Pageable paginacao);
}
