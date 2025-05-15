package com.lanchonete.api.adapters.driven.repository;

import com.lanchonete.api.adapters.domains.produto.ProductDTO;
import com.lanchonete.api.adapters.driven.entity.ProductEntity;
import com.lanchonete.api.core.model.models.Product;
import com.lanchonete.api.core.portas.repository.ProductRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ProductRepository implements ProductRepositoryPort {

    private final SpringProductRepository springProductRepository;

    public ProductRepository(SpringProductRepository springProductRepository)
    {
        this.springProductRepository = springProductRepository;
    }

    @Override
    public ProductEntity save(Product product) {

        ProductEntity productEntity =  new ProductEntity(product);
        return this.springProductRepository.save(productEntity);
    }

    @Override
    public ProductEntity update(Product product) {
        ProductEntity productEntity =  this.springProductRepository.findById(product.getId()).get();
        productEntity.updateProduct(product);
        return this.springProductRepository.save(productEntity);
    }

    @Override
    public Product getReferenceById(long id) {
        ProductEntity productEntity =  this.springProductRepository.getReferenceById(id);
        return productEntity.toProduct();
    }

    @Override
    public Page<Product> findAllByActiveTrue(Pageable pageable) {
        Page<ProductEntity> produtoEntity = this.springProductRepository.findAllByActiveTrue(pageable);
        Page<Product> produtos = produtoEntity.map(ProductEntity::toProduct);
        return produtos;
    }

}
