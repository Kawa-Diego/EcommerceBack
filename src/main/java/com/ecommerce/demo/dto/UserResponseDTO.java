package com.ecommerce.demo.dto;

import com.ecommerce.demo.model.User;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String name,
        String email,
        String cpf
) {
    public static UserResponseDTO fromEntity(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCpf()
        );
    }
}
