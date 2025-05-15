package com.lanchonete.api.infrastructure.config;

import com.lanchonete.api.core.portas.repository.ProductRepositoryPort;
import com.lanchonete.api.core.portas.service.ProductServicePort;
import com.lanchonete.api.core.service.ProductServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracao {

    //Realiza a injeção de depência no Service de forma externa, para não depender do Framework do Spring
    @Bean
    ProductServicePort productService(ProductRepositoryPort productRepositoryPort){
        return new ProductServiceImp(productRepositoryPort);
    }
}
