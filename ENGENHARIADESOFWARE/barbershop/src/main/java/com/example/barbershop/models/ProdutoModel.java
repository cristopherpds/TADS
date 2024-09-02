package com.example.barbershop.models;

public class ProdutoModel {
    private String nome;
    private String descricao;
    private double preco;
    private int quantEmEstoque;
    
    public ProdutoModel(String nome, String descricao, double preco, int quantEmEstoque) {
        if (preco <= 0) {
            throw new IllegalArgumentException("O valor do produto deve ser maior que 0.");
        }
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantEmEstoque = quantEmEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantEmEstoque() {
        return quantEmEstoque;
    }

    public void setQuantEmEstoque(int quantEmEstoque) {
        this.quantEmEstoque = quantEmEstoque;
    }

    public void adicionarAoEstoque(int quantidade) {
        this.quantEmEstoque += quantidade;
    }
    
    public void removerDoEstoque(int quantidade) {
        if (this.quantEmEstoque >= quantidade) {
            this.quantEmEstoque -= quantidade;
        } else {
            System.out.println("Quantidade insuficiente em estoque!");
        }
    }
}
