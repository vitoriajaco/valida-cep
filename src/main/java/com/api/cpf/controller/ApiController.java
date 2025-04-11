package com.api.cpf.controller;

import com.api.cpf.client.EnderecoService;
import com.api.cpf.response.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    EnderecoService enderecoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> retornaEndereco(@PathVariable String cep){
        Endereco endereco = enderecoService.getAddressByCep(cep);

        return ResponseEntity.ok(endereco);

    }
}
