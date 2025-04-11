package com.api.cpf.client;

import com.api.cpf.response.Endereco;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.time.Duration;

@Service
public class EnderecoService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    //private static final HttpClient httpClient = HttpClient.newHttpClient();

    private final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10)) // Timeout de conexão
            .build();

    public  Endereco getAddressByCep(String cep) {
        // Validação do CEP
        if (!isValidCep(cep)) {
            throw new IllegalArgumentException("CEP inválido: " + cep);
        }

        try {
            // Fazendo a requisição HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/"))
                    .GET()
                    .timeout(Duration.ofSeconds(10)) // Timeout da requisição
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificando se a resposta foi bem-sucedida
            if (response.statusCode() != 200) {
                throw new RuntimeException("Erro ao buscar o endereço. Código HTTP: " + response.statusCode());
            }

            // Mapeando o JSON para o objeto Address
            return objectMapper.readValue(response.body(), Endereco.class);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar o endereço para o CEP: " + cep, e);
        }
    }

    private static boolean isValidCep(String cep) {
        return cep != null && cep.matches("\\d{8}");
    }
}