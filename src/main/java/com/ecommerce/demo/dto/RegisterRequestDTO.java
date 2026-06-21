package com.ecommerce.demo.dto;

import com.ecommerce.demo.validation.StrongPassword;
import com.ecommerce.demo.validation.ValidCpf;
import com.ecommerce.demo.validation.ValidationPatterns;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
        String name,

        @NotBlank(message = "E-mail é obrigatório")
        @Pattern(regexp = ValidationPatterns.EMAIL, message = "E-mail inválido")
        String email,

        @NotBlank(message = "Senha é obrigatória")
        @StrongPassword
        String password,

        @NotBlank(message = "CPF é obrigatório")
        @ValidCpf
        String cpf
) {
}
