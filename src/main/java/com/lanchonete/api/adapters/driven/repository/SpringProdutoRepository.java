package com.lanchonete.api.adapters.driven.repository;

import com.lanchonete.api.core.model.models.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringProdutoRepository extends JpaRepository<Produto, Long> {

    Page<Produto> findAllByAtivoTrue(Pageable paginacao);
}
