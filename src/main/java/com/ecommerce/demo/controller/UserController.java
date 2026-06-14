package com.ecommerce.demo.controller;

import com.sun.net.httpserver.Request;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @GetMapping
    public String apiList() { 
        return "api list";
    }

    @GetMapping("/user")
    public String getAllUsers() {
        return "All Users";
    }

    @GetMapping("/{id}")
    public String getSingleUser() {
        return "Hello World!";
    }

//    @PostMapping("/createUser")
//    public String createUser(Request request){
//
//    }

}