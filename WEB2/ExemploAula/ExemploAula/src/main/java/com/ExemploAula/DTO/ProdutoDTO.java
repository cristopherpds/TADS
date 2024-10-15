package com.ExemploAula.dto;


import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ProdutoDTO(@NotBlank String nome, @NonNull @Positive double preco, int categoriaId) {

}
