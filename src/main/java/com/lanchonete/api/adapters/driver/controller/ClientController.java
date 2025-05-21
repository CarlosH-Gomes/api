package com.lanchonete.api.adapters.driver.controller;


import com.lanchonete.api.adapters.domains.client.ClientDTO;
import com.lanchonete.api.adapters.domains.client.ClientForm;
import com.lanchonete.api.core.model.models.Client;
import com.lanchonete.api.core.portas.service.ClientServicePort;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/clients")
public class ClientController {

    private final ClientServicePort clientService;

    public ClientController(ClientServicePort clientService){
        this.clientService = clientService;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<ClientDTO> create(
            @Valid @RequestBody ClientForm clientForm,
            UriComponentsBuilder uriComponentsBuilder){

        if(this.clientService.existsByEmail(clientForm.email()))
            throw new RuntimeException("Email already registered");

        Client newClient = this.clientService.create(ClientForm.toModel(clientForm));
        URI uri = uriComponentsBuilder.path("client?cpf={cpf}").buildAndExpand(newClient.getCpf()).toUri();

        return ResponseEntity.created(uri).body(ClientDTO.toDTO(newClient));
    }

    @GetMapping
    public ResponseEntity<ClientDTO> getByCpf(@RequestParam String cpf){
        Client client = this.clientService.findByCpf(cpf);
        return new ResponseEntity<>(ClientDTO.toDTO(client), HttpStatus.OK);
    }
}

