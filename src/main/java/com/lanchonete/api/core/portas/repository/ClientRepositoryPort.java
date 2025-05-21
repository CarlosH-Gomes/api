package com.lanchonete.api.core.portas.repository;

import com.lanchonete.api.core.model.models.Client;

public interface ClientRepositoryPort {
    Client save(Client client);
    Client findByCpf(String cpf);
    boolean existsByEmail(String email);
}
