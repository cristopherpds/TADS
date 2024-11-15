package com.example.atividade1.atividade1.dtos;

import java.util.Set;

public record CategoriaDTO(Long id, String nome, Set<CursoDTO> cursos) {

}
