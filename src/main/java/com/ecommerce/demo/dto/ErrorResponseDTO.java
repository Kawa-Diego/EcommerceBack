package com.ecommerce.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponseDTO(
        int status,
        String message,
        List<String> errors,
        LocalDateTime timestamp
) {
    public static ErrorResponseDTO of(int status, String message) {
        return new ErrorResponseDTO(status, message, List.of(), LocalDateTime.now());
    }

    public static ErrorResponseDTO of(int status, String message, List<String> errors) {
        return new ErrorResponseDTO(status, message, errors, LocalDateTime.now());
    }
}
