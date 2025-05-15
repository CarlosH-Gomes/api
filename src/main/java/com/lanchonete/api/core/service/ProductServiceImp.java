package com.lanchonete.api.core.service;

import com.lanchonete.api.adapters.domains.produto.ProductDTO;
import com.lanchonete.api.adapters.domains.produto.ProductForm;
import com.lanchonete.api.adapters.driven.entity.ProductEntity;
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
    public ProductDTO save(ProductForm productForm) {
        Product product = new Product(productForm);
        ProductEntity productSave = repository.save(product);
        return new ProductDTO(productSave.getId(), productSave.getCategory(), productSave.getName(), productSave.getPrice(), productSave.getDescription(), productSave.getActive());
    }

    @Override
    public ProductDTO update(ProductForm productForm) {
        var product = repository.getReferenceById(productForm.id());
        product.updateProduto(productForm);
        ProductEntity productSave =   repository.update(product);
        return new ProductDTO(productSave.getId(), productSave.getCategory(), productSave.getName(), productSave.getPrice(), productSave.getDescription(), productSave.getActive());
    }

    @Override
    public void delete(Long id) {
        var product = repository.getReferenceById(id);
        product.setActiveFalse();
        repository.update(product);
    }

    @Override
    public Page<ProductForm> recover(Pageable pageable) {
        return repository.findAllByActiveTrue(pageable).map(ProductForm::new);
    }

}
