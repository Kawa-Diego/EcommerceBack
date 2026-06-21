package com.ecommerce.demo.controller;

import com.ecommerce.demo.dto.HomeResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping({"", "/"})
    public ResponseEntity<HomeResponseDTO> home() {
        return ResponseEntity.ok(new HomeResponseDTO(
                """
                    Bem-vindo ao seu Cardápio Digital.
                    Para propósito curricular
                """,
                "online"
        ));
    }
}
