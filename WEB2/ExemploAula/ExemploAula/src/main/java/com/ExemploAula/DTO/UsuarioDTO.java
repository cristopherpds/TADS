package com.ExemploAula.DTO;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(@NotBlank String nome,  @NotBlank String email, @NotBlank String senha, @NotBlank String tipo) {

}
