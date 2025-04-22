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
   private EnderecoService enderecoService;

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> retornaEndereco(@PathVariable String cep){ //O Path variable por default nao aceita valor vazio

        Endereco endereco = enderecoService.getAddressByCep(cep);

        return ResponseEntity.ok(endereco);

    }

    @GetMapping("/") //Maneira para garantir que o usuario ao passar uma requisicao sem valor de cep receba um erro
    public ResponseEntity<String> handleEmptyCep() {
        throw new IllegalArgumentException("O CEP não pode ser nulo ou vazio.");
    }
}
