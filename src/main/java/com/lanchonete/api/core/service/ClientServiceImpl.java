package com.lanchonete.api.core.service;

import com.lanchonete.api.core.model.models.Client;
import com.lanchonete.api.core.portas.repository.ClientRepositoryPort;
import com.lanchonete.api.core.portas.service.ClientServicePort;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientServicePort {

    private final ClientRepositoryPort clientRepository;

    public ClientServiceImpl(ClientRepositoryPort clientRepository){
        this.clientRepository = clientRepository;
    };

    @Override
    public Client create(Client client) {
        return this.clientRepository.save(client);
    }

    @Override
    public Client findByCpf(String cpf) {
        return this.clientRepository.findByCpf(cpf);
    }

    @Override
    public boolean existsByEmail(String email) {
        return this.clientRepository.existsByEmail(email);
    }
}
