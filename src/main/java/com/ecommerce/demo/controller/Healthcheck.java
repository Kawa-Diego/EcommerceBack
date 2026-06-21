package com.ecommerce.demo.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/actuator/health")
public class Healthcheck {
    
    @GetMapping
    private ResponseEntity<Map<String, String>> healthCheck() {
        try {
            String status = "";
            if (status.equals("UP")) {
                return ResponseEntity.ok(Map.of(
                    "status", "UP",
                    "message", "Servidor está saudável"
                ));
            } else {
                return ResponseEntity.status(503).body(Map.of(
                    "status", "DOWN",
                    "message", "Servidor está indisponível"
                ));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of(
                "status", "error",
                "message", "Erro ao verificar saúde do servidor"
            ));
        }
    }
}
