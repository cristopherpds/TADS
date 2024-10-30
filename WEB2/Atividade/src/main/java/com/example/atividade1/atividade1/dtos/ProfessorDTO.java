package com.example.atividade1.atividade1.dtos;

import jakarta.validation.constraints.NotBlank;

public record ProfessorDTO(Long id, @NotBlank String nome, @NotBlank String email, @NotBlank String foto) {

}
