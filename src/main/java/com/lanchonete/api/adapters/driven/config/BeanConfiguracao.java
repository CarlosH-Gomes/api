package com.lanchonete.api.adapters.driven.config;

import com.lanchonete.api.core.portas.repository.ProdutoRepositoryPort;
import com.lanchonete.api.core.portas.service.ProdutoServicePort;
import com.lanchonete.api.core.service.ProdutoServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracao {

    //Realiza a injeção de depência no Service de forma externa, para não depender do Framework do Spring
    @Bean
    ProdutoServicePort produtoService(ProdutoRepositoryPort produtoRepositoryPort){
        return new ProdutoServiceImp(produtoRepositoryPort);
    }
}
