package com.lanchonete.api.core.model.models;

import java.time.LocalDateTime;

public class Client {
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Client(){};

    public Client(Long id, String name, String cpf, String email, String phone, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
    }

    public Client(String name, String cpf, String email, String phone){
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
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
}
