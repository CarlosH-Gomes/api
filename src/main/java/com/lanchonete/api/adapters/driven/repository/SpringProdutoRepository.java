package com.lanchonete.api.adapters.driven.repository;

import com.lanchonete.api.core.model.models.Enum.Categoria;
import com.lanchonete.api.core.model.models.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Classe de implementação
@Repository
public interface SpringProdutoRepository extends JpaRepository<Produto, Long> {

    Page<Produto> findAllByAtivoTrue(Pageable paginacao);

    Page<Produto> findAllByCategoriaAndAtivo(Categoria categoria,boolean ativo, Pageable paginacao);
}
