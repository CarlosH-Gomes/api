package com.lanchonete.api.adapters.driver.controller;

import com.lanchonete.api.adapters.domains.produto.FilterProductDTO;
import com.lanchonete.api.adapters.domains.produto.ProductDTO;
import com.lanchonete.api.adapters.domains.produto.ProductForm;
import com.lanchonete.api.core.portas.service.ProductServicePort;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
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
    public ResponseEntity<ProductDTO> create(@RequestBody @Valid ProductForm productForm, UriComponentsBuilder uriBuilder) {
        ProductDTO productDTO = service.save(productForm);

        URI uri = uriBuilder.path("/api/products/{id}").buildAndExpand(productDTO.getId()).toUri();
        return  ResponseEntity.created(uri).body(productDTO);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ProductDTO> update(@RequestBody @Valid ProductForm productForm){
        return new ResponseEntity<>(service.update(productForm),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public Page<ProductForm> listar(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        return service.recover(pageable);
    }

    @PostMapping("/search")
    public ResponseEntity<?> findAllByFilter(@RequestBody FilterProductDTO filter,
                                                  @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                                                  @RequestParam(name = "status", required = false) String status) {

        return ResponseEntity.ok().body(service.findAllByFilter(filter, pageable));
    }

}
