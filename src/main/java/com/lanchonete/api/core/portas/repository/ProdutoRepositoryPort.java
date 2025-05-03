package com.lanchonete.api.core.portas.repository;

import com.lanchonete.api.core.model.models.Enum.Categoria;
import com.lanchonete.api.core.model.models.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoRepositoryPort {
    void save(Produto produto);
    Produto getReferenceById(long id);
    Page<Produto> findAllByAtivoTrue(Pageable paginacao);
    Page<Produto> findAllByCategoriaAndAtivo(Pageable paginacao, Categoria categoria);
}
