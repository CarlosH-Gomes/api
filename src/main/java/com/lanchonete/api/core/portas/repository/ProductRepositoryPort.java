package com.lanchonete.api.core.portas.repository;

import com.lanchonete.api.core.model.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface ProductRepositoryPort {
    void save(Product product);
    void update(Product product);
    Product getReferenceById(long id);
    Page<Product> findAllByActiveTrue(Pageable pageable);
}
