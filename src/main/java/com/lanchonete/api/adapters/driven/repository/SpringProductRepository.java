package com.lanchonete.api.adapters.driven.repository;

import com.lanchonete.api.adapters.driven.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;


@Repository
public interface SpringProductRepository extends JpaRepository<ProductEntity, Long> {
   Page<ProductEntity> findAllByActiveTrue(Pageable paginacao);
}
