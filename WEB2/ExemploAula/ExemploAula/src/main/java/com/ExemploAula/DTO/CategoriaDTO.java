package com.ExemploAula.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoriaDTO(@NotBlank String descricao) {

}
