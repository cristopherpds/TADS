package com.example.barbershop.models;

public class RelatorioModel {
    private String vendaPorDia;
    private String vendaPorFuncionario;
    private String produtosMaisVendidos;

    public String getVendaPorDia() {
        return vendaPorDia;
    }

    public void setVendaPorDia(String vendaPorDia) {
        this.vendaPorDia = vendaPorDia;
    }

    public String getVendaPorFuncionario() {
        return vendaPorFuncionario;
    }

    public void setVendaPorFuncionario(String vendaPorFuncionario) {
        this.vendaPorFuncionario = vendaPorFuncionario;
    }

    public String getProdutosMaisVendidos() {
        return produtosMaisVendidos;
    }

    public void setProdutosMaisVendidos(String produtosMaisVendidos) {
        this.produtosMaisVendidos = produtosMaisVendidos;
    }
}
