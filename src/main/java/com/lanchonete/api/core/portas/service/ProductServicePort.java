package com.lanchonete.api.core.portas.service;

import com.lanchonete.api.adapters.domains.produto.ProductDTO;
import com.lanchonete.api.adapters.domains.produto.UpdateProductForm;
import com.lanchonete.api.adapters.domains.produto.CreateProductForm;
import com.lanchonete.api.adapters.domains.produto.ListProductForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductServicePort {

     ProductDTO save(CreateProductForm createProductForm);
     ProductDTO update(UpdateProductForm updateProductForm);
     void delete(Long id);
     Page<ListProductForm> recover(Pageable pageable);

}
