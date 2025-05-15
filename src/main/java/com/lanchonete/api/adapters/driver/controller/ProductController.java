package com.lanchonete.api.adapters.driver.controller;

import com.lanchonete.api.adapters.DTO.DadosUpdateProduct;
import com.lanchonete.api.adapters.DTO.DadosCreateProduct;
import com.lanchonete.api.adapters.DTO.DadosListProduct;
import com.lanchonete.api.core.portas.service.ProductServicePort;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductServicePort service;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid DadosCreateProduct dadosCreateProduct){
        service.save(dadosCreateProduct);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DadosUpdateProduct dadosUpdateProduct){
        service.update(dadosUpdateProduct);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping
    public Page<DadosListProduct> listar(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        return service.recover(pageable);
    }

}
