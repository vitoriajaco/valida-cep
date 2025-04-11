package com.api.cpf.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Endereco {

    private String localidade;
    private String uf;

    private String cep;

    private String bairro;

    public Endereco() {
    }

    public Endereco(String localidade, String uf, String cep, String bairro) {
        this.localidade = localidade;
        this.uf = uf;
        this.cep = cep;
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", cep='" + cep + '\'' +
                ", bairro='" + bairro + '\'' +
                '}';
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }

    public String getBairro() {
        return bairro;
    }
}
