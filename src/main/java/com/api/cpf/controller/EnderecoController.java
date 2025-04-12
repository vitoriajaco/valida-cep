package com.api.cpf.controller;

import com.api.cpf.client.EnderecoService;
import com.api.cpf.response.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/buscar")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> retornaEndereco(@PathVariable String cep){
        if (cep == null || cep.isEmpty()) {
            throw new IllegalArgumentException("O CEP não pode ser nulo ou vazio.");
        }
        Endereco endereco = enderecoService.getAddressByCep(cep);

        return ResponseEntity.ok(endereco);

    }
}
