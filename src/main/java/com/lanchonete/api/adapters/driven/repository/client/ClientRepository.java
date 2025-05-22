package com.lanchonete.api.adapters.driven.repository.client;

import com.lanchonete.api.adapters.driven.entity.ClientEntity;
import com.lanchonete.api.core.model.models.Client;
import com.lanchonete.api.core.portas.repository.ClientRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class ClientRepository implements ClientRepositoryPort {

    private final ClientJpaRepository jpaRepository;

    public ClientRepository(ClientJpaRepository jpaRepository){
        this.jpaRepository = jpaRepository;
    }

    public Client save(Client client){
        ClientEntity newClient = jpaRepository.save(new ClientEntity(client));
        return newClient.toModel();
    }

    public Client findByCpf(String cpf) {
        ClientEntity jpaClient = this.jpaRepository.findByCpf(cpf);
        if(jpaClient == null) return null;
        return jpaClient.toModel();
    }

    public boolean existsByEmailOrByCpf(String email, String cpf) {
        return this.jpaRepository.existsByEmailOrCpf(email, cpf);
    }
}
