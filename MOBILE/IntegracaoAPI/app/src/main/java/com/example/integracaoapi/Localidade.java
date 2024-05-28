package com.example.integracaoapi;

public class Localidade {
    private String cep;
    private String logradouro;
    private String bairro;
    private  String localidade;

    public Localidade() {
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }
    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @Override
    public String toString() {
        return "Localidade{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                '}';
    }
}
