package com.ecommerce.demo.dto;

import com.ecommerce.demo.validation.ValidationPatterns;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record LoginReqDTO(
        @NotBlank(message = "E-mail é obrigatório")
        @Pattern(regexp = ValidationPatterns.EMAIL, message = "E-mail inválido")
        String email,

        @NotBlank(message = "Senha é obrigatória")
        String password
) {
}
