package com.lanchonete.api.core.portas.service;

import com.lanchonete.api.core.model.models.Client;

public interface ClientServicePort {
    Client create(Client client);
    Client findByCpf(String cpf);
    boolean existsByEmail(String email);
}
