package com.ecommerce.demo.security;

import com.ecommerce.demo.dto.ErrorResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AdminApiKeyFilter extends OncePerRequestFilter {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String ADMIN_HEADER = "${X_ADMIN_DEV}";

    @Value("${api.admin.secret-key:}")
    private String adminSecretKey;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        return !path.startsWith("/api/admin");
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        if (adminSecretKey == null || adminSecretKey.isBlank()) {
            writeForbidden(response, "Chave administrativa não configurada no servidor");
            return;
        }

        String providedKey = request.getHeader(ADMIN_HEADER);

        if (providedKey == null || !adminSecretKey.equals(providedKey)) {
            writeForbidden(response, "Acesso administrativo negado");
            return;
        }

        filterChain.doFilter(request, response);
    }

    private void writeForbidden(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        ErrorResponseDTO body = ErrorResponseDTO.of(HttpStatus.FORBIDDEN.value(), message);
        OBJECT_MAPPER.writeValue(response.getOutputStream(), body);
    }
}
