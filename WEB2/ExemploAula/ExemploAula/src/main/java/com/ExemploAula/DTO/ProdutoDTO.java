package com.ExemploAula.dto;

import com.ExemploAula.model.CategoriaModel;

import jakarta.validation.constraints.NotBlank;

public record ProdutoDTO(@NotBlank String nome, @NotBlank double preco, int categoriaId) {

}
