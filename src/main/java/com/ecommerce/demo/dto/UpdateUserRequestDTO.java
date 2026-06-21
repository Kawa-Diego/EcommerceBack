package com.ecommerce.demo.dto;

import com.ecommerce.demo.validation.StrongPassword;
import com.ecommerce.demo.validation.ValidCpf;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateUserRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
        String name,

        @NotBlank(message = "Senha é obrigatória")
        @StrongPassword
        String password,

        @NotBlank(message = "CPF é obrigatório")
        @ValidCpf
        String cpf
) {
}
