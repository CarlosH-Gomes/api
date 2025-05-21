package com.lanchonete.api.adapters.driven.repository.client;

import com.lanchonete.api.adapters.driven.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientJpaRepository extends JpaRepository<ClientEntity, Long> {
    ClientEntity findByCpf(String cpf);
    boolean existsByEmail(String email);
}
