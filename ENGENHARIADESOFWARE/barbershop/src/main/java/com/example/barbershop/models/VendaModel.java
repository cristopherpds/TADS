package com.example.barbershop.models;

import java.time.LocalDate;

public class VendaModel {
    private LocalDate dataVenda;
    private ClienteModel cliente;
    private ProdutoModel items;
    private FuncionarioModel funcionario;

    public VendaModel(LocalDate dataVenda, ClienteModel cliente, ProdutoModel items, FuncionarioModel funcionario) {
         if (items == null) {
            throw new IllegalArgumentException("Produto/Serviço é obrigatório.");
        }
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente é obrigatório.");
        }
        if (funcionario == null || funcionario == null) {
            throw new IllegalArgumentException("Barbeiro é obrigatório.");
        }

        this.dataVenda = (dataVenda != null) ? dataVenda : LocalDate.now();
        this.cliente = cliente;
        this.items = items;
        this.funcionario = funcionario;
    }
    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public ProdutoModel getItems() {
        return items;
    }

    public void setItems(ProdutoModel items) {
        this.items = items;
    }

    public FuncionarioModel getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioModel funcionario) {
        this.funcionario = funcionario;
    }

}
