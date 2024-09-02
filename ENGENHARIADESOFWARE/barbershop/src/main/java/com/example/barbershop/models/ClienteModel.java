package com.example.barbershop.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.barbershop.utils.CPFValidator;

public class ClienteModel {
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private List<AgendamentoModel> agendamentos = new ArrayList();
    
    public ClienteModel(int id, String nome, String telefone, String email, String cpf) {
        if (!CPFValidator.isCPF(cpf)) {
            throw new IllegalArgumentException("cpf inválido.");
        }
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getcpf() {
        return cpf;
    }

    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

    public void agendarServico(ClienteModel cliente, FuncionarioModel barbeiro, ServicoModel servico, LocalDate dataHora) {
        AgendamentoModel agendamento = new AgendamentoModel(null, cliente, servico, barbeiro);
        this.agendamentos.add(agendamento);
    }


    public static boolean isValidBrazilianContact(String telefone) {
        return telefone.matches("^\\(\\d{2}\\)\\d{4,5}-\\d{4}$");
    }

    public static boolean isValidUruguayanContact(String telefone) {
        return telefone.matches("^\\+598\\d{8,9}$");
    }
}
