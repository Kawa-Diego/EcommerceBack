package com.ecommerce.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api")
public class UserController {

    @GetMapping("/user")
    public ResponseEntity<String> getAllUsers() {
        return ResponseEntity.ok("sucesso");
    }

//    @GetMapping("/user/{id}")]
//    public ResponseEntity(String) getUserById(@PathVariable("id") Long id) {
//        return userService.findById(id)
//                .map(user -> ResponseEntity.ok(user))
//                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
//    }



}