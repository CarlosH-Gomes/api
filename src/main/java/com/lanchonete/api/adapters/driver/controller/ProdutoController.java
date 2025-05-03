package com.lanchonete.api.adapters.driver.controller;

import com.lanchonete.api.core.model.DTO.DadosAtualizaProduto;
import com.lanchonete.api.core.model.DTO.DadosCadastroProduto;
import com.lanchonete.api.core.model.DTO.DadosListagemProduto;
import com.lanchonete.api.core.model.models.Enum.Categoria;
import com.lanchonete.api.core.portas.service.ProdutoServicePort;
import com.lanchonete.api.core.service.ProdutoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoServicePort service;

    @PostMapping(consumes = "multipart/form-data")
    @Transactional
    public void cadastrar(@ModelAttribute DadosCadastroProduto dados){

        service.salvar(dados);

    }

    @GetMapping
    public Page<DadosListagemProduto> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){

        return service.recuperar(paginacao);

    }

    @GetMapping("/{categoria}")
    public Page<DadosListagemProduto> listarCategoria(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao, @PathVariable Categoria categoria){

        return service.recuperar(paginacao,categoria);

    }

    @PutMapping(consumes = "multipart/form-data")
    @Transactional
    public void atualizar(@ModelAttribute DadosAtualizaProduto dados){
       service.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        service.deletar(id);

    }




}
