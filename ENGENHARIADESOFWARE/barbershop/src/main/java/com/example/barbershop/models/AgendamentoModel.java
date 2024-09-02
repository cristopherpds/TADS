package com.example.barbershop.models;


import java.time.LocalDate;


public class AgendamentoModel {
    private LocalDate dataHoraAgendamento;
    private ClienteModel cliente;
    private ServicoModel service;
    private FuncionarioModel funcionario;


    public AgendamentoModel(LocalDate dataHoraAgendamento, ClienteModel cliente, ServicoModel service,
            FuncionarioModel funcionario) {
        this.dataHoraAgendamento = dataHoraAgendamento;
        this.cliente = cliente;
        this.service = service;
        this.funcionario = funcionario;
    }

    public  LocalDate getDataHoraAgendamento() {
        return dataHoraAgendamento;
    }

    public void setDataHoraAgendamento(LocalDate dataHoraAgendamento) {
        this.dataHoraAgendamento = dataHoraAgendamento;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public ServicoModel getService() {
        return service;
    }

    public void setService(ServicoModel service) {
        this.service = service;
    }

    public FuncionarioModel getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioModel funcionario) {
        this.funcionario = funcionario;
    }
}
