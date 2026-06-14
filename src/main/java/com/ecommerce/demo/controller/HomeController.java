package com.ecommerce.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class HomeController {
    @GetMapping
    public String Home(HttpServletRequest request) {
        try {
            return "Hello World 30" +
                    " " + request.getSession().getId();
        }catch (Error error) {
            return ("Internal server error "+ error);
        }
    }

    public String projects;
    
}
