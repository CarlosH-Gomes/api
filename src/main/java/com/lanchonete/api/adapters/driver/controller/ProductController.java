package com.lanchonete.api.adapters.driver.controller;

import com.lanchonete.api.adapters.domains.produto.ProductDTO;
import com.lanchonete.api.adapters.domains.produto.UpdateProductForm;
import com.lanchonete.api.adapters.domains.produto.CreateProductForm;
import com.lanchonete.api.adapters.domains.produto.ListProductForm;
import com.lanchonete.api.core.portas.service.ProductServicePort;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductServicePort service;

    @PostMapping
    @Transactional
    public ResponseEntity<ProductDTO> create(@RequestBody @Valid CreateProductForm createProductForm) {
        return new ResponseEntity<>(service.save(createProductForm), HttpStatus.CREATED);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ProductDTO> update(@RequestBody @Valid UpdateProductForm updateProductForm){
        return new ResponseEntity<>(service.update(updateProductForm),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public Page<ListProductForm> listar(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        return service.recover(pageable);
    }

}
