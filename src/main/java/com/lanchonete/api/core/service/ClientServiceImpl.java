package com.lanchonete.api.core.service;

import com.lanchonete.api.core.model.models.Client;
import com.lanchonete.api.core.portas.repository.ClientRepositoryPort;
import com.lanchonete.api.core.portas.service.ClientServicePort;
import com.lanchonete.api.infrastructure.exceptions.NotFoundException;
import com.lanchonete.api.infrastructure.exceptions.UniqueViolation;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientServicePort {

    private final ClientRepositoryPort clientRepository;

    public ClientServiceImpl(ClientRepositoryPort clientRepository){
        this.clientRepository = clientRepository;
    };

    @Override
    public Client create(Client client) {
        if(this.clientRepository.existsByEmailOrByCpf(client.getEmail(), client.getCpf()))
            throw new UniqueViolation("Email/CPF already registered");
        return this.clientRepository.save(client);
    }

    @Override
    public Client findByCpf(String cpf) {
        Client client = this.clientRepository.findByCpf(cpf);
        if(client == null)
            throw new NotFoundException("Client not found");
        return client;
    }

}
