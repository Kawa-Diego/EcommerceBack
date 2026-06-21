package com.ecommerce.demo.controller;

import com.ecommerce.demo.dto.AuthResponseDTO;
import com.ecommerce.demo.dto.LoginReqDTO;
import com.ecommerce.demo.dto.RegisterRequestDTO;
import com.ecommerce.demo.dto.RegisterResponseDTO;
import com.ecommerce.demo.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody LoginReqDTO body) {
        AuthResponseDTO response = authService.login(body);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@Valid @RequestBody RegisterRequestDTO body) {
        RegisterResponseDTO response = authService.register(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
