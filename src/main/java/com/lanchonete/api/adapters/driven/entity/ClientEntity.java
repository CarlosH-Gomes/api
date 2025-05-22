package com.lanchonete.api.adapters.driven.entity;

import com.lanchonete.api.core.model.models.Client;
import jakarta.persistence.*;
import java.time.LocalDateTime;

    @Entity
    @Table(name="clients")
    public class ClientEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name="name", nullable = false, length = 155)
        private String name;
        @Column(name="cpf", unique = true, length = 11)
        private String cpf;
        @Column(name="email", nullable = false, unique = true, length = 155)
        private String email;
        @Column(name="phone", length = 55)
        private String phone;
        @Column(name="created_at")
        private LocalDateTime createdAt = LocalDateTime.now();
        @Column(name="updated_at")
        private LocalDateTime updatedAt;

        public ClientEntity(Client client){
            this.name = client.getName();
            this.cpf = client.getCpf();
            this.email = client.getEmail();
            this.phone = client.getPhone();
        }

        public ClientEntity() {
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getCpf() {
            return cpf;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public LocalDateTime getUpdatedAt() {
            return updatedAt;
        }

        public Client toModel(){
            return new Client(this.id, this.name, this.cpf, this.email, this.phone, this.createdAt);
        }
    }
