package com.example.barbershop.models;


import java.time.LocalDate;

import com.example.barbershop.utils.CPFValidator;

public class FuncionarioModel {
    private String nome;
    private String cargo;
    private Double salario;
    private Double commissao;
    private String cpf;
    private LocalDate horario;

    public FuncionarioModel(String nome, String cargo, Double salario, Double commissao, String cpf, LocalDate horario) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome do funcionário é obrigatório.");
        }
        if (!CPFValidator.isCPF(cpf)) {
            throw new IllegalArgumentException("cpf inválido.");
        }
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.commissao = commissao;
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getCommissao() {
        return commissao;
    }

    public void setCommissao(Double commissao) {
        this.commissao = commissao;
    }

    public LocalDate getHorario() {
        return horario;
    }

    public void setHorario(LocalDate horario) {
        this.horario = horario;

    }

    public void realizarServico(ServicoModel servico) {
        double valorServico = servico.getValor();
        double comissaoServico = valorServico * 0.1;
        this.commissao += comissaoServico;
    }

}
