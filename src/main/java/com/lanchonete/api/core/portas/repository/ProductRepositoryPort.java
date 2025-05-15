package com.lanchonete.api.core.portas.repository;

import com.lanchonete.api.adapters.domains.produto.ProductDTO;
import com.lanchonete.api.adapters.driven.entity.ProductEntity;
import com.lanchonete.api.core.model.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface ProductRepositoryPort {
    ProductEntity save(Product product);
    ProductEntity update(Product product);
    Product getReferenceById(long id);
    Page<Product> findAllByActiveTrue(Pageable pageable);
}
