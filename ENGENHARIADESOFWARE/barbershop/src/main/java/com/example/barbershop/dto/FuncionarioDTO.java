package com.example.barbershop.dto;

import java.time.LocalDate;

public record FuncionarioDTO(String nome, String cargo, Double salario, Double commissao, LocalDate horario) {}
