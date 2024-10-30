package com.example.atividade1.atividade1.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.atividade1.atividade1.models.Curso;

public interface CursoService {
    List<Curso> findAll();
    Page<Curso> findAll(Pageable pageable);
    Page<Curso> findByCategoriaId(Long categoriaId, Pageable pageable);
    Page<Curso> findByNomeContaining(String nome, Pageable pageable);
    Optional<Curso> findById(Long id);
    Curso save(Curso curso);
    void deleteById(Long id);
    List<Curso> findByCategoriaId(Long categoriaId);
    List<Curso> findByNomeContaining(String nome);
}
