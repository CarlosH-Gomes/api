package com.lanchonete.api.core.service;

import com.lanchonete.api.adapters.DTO.DadosUpdateProduct;
import com.lanchonete.api.adapters.DTO.DadosCreateProduct;
import com.lanchonete.api.adapters.DTO.DadosListProduct;
import com.lanchonete.api.core.model.models.Product;
import com.lanchonete.api.core.portas.repository.ProductRepositoryPort;
import com.lanchonete.api.core.portas.service.ProductServicePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public class ProductServiceImp implements ProductServicePort {


    private ProductRepositoryPort repository;

    public ProductServiceImp(ProductRepositoryPort productRepositoryPort) {
        this.repository = productRepositoryPort;
    }

    @Override
    public void save(DadosCreateProduct dadosCreateProduct) {
        Product product = new Product(dadosCreateProduct);
        repository.save(product);
    }

    @Override
    public void update(DadosUpdateProduct dadosUpdateProduct) {
        var product = repository.getReferenceById(dadosUpdateProduct.id());
        product.updateProduto(dadosUpdateProduct);
        repository.update(product);
    }

    @Override
    public void delete(Long id) {
        var product = repository.getReferenceById(id);
        product.setActiveFalse();
        repository.update(product);
    }

    @Override
    public Page<DadosListProduct> recover(Pageable pageable) {
        return repository.findAllByActiveTrue(pageable).map(DadosListProduct::new);
    }

}
