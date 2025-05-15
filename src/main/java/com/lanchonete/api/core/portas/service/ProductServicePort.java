package com.lanchonete.api.core.portas.service;

import com.lanchonete.api.adapters.domains.produto.ProductDTO;
import com.lanchonete.api.adapters.domains.produto.ProductForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductServicePort {

     ProductDTO save(ProductForm productForm);
     ProductDTO update(ProductForm productForm);
     void delete(Long id);
     Page<ProductForm> recover(Pageable pageable);

}
