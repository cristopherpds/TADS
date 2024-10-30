package com.example.atividade1.atividade1.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.atividade1.atividade1.models.Curso;

public interface CursoService {
    List<Curso> findAll();
    Optional<Curso> findById(Long id);
    Curso save(Curso curso);
    void deleteById(Long id);
    List<Curso> findByCategoriaId(Long categoriaId);
    List<Curso> findByNomeContaining(String nome);
}
