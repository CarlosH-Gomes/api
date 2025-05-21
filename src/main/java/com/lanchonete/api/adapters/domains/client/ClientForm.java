package com.lanchonete.api.adapters.domains.client;

import com.lanchonete.api.core.model.models.Client;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientForm(
        @NotBlank(message = "Nome should not be null or blank")
        String name,
        String cpf,
        @NotBlank(message = "Email should not be null or blank")
        @Email
        String email,
        @NotBlank(message = "Phone should not be null or blank")
        String phone
) {
    public static Client toModel(ClientForm form){
        return new Client(form.name, form.cpf, form.email, form.phone);
    }
}
