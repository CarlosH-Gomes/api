package com.lanchonete.api.adapters.domains.client;

import com.lanchonete.api.core.model.models.Client;

import java.time.LocalDateTime;

public record ClientDTO (
        Long id,
        String name,
        String cpf,
        String email,
        String phone,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static ClientDTO toDTO(Client client) {
        return new ClientDTO(
                client.getId(),
                client.getName(),
                client.getCpf(),
                client.getEmail(),
                client.getPhone(),
                client.getCreatedAt(),
                client.getUpdatedAt()
        );
    }
}

