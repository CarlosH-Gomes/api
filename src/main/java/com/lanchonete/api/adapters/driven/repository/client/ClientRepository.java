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
        ClientEntity clientJPAEntity = new ClientEntity(client);
        ClientEntity newClient = jpaRepository.save(clientJPAEntity);
        return new Client(
                newClient.getId(),
                newClient.getName(),
                newClient.getCpf(),
                newClient.getEmail(),
                newClient.getPhone(),
                newClient.getCreatedAt());
    }

    @Override
    public Client findByCpf(String cpf) {
        ClientEntity jpaClient = this.jpaRepository.findByCpf(cpf);
        return new Client(
                jpaClient.getId(),
                jpaClient.getName(),
                jpaClient.getCpf(),
                jpaClient.getEmail(),
                jpaClient.getPhone(),
                jpaClient.getCreatedAt());
    }

    @Override
    public boolean existsByEmail(String email) {
        return this.jpaRepository.existsByEmail(email);
    }

}
