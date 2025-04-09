package com.api.cpf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/cep")
public class ApiController {

    @GetMapping("/hello")
    public String hello (String s){
        return "Oi mundo";

    }
}
