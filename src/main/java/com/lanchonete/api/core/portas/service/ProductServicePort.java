package com.lanchonete.api.core.portas.service;

import com.lanchonete.api.adapters.DTO.DadosUpdateProduct;
import com.lanchonete.api.adapters.DTO.DadosCreateProduct;
import com.lanchonete.api.adapters.DTO.DadosListProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

public interface ProductServicePort {

     void save(DadosCreateProduct dadosCreateProduct);
     void update(DadosUpdateProduct dadosUpdateProduct);
     void delete(Long id);
     Page<DadosListProduct> recover(Pageable pageable);

}
