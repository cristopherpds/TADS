package com.example.atividade1.atividade1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atividade1.atividade1.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
    List<Curso> findByCategoriaId(Long categoriaId);
    List<Curso> findByNomeContainingIgnoreCase(String nome);
}
