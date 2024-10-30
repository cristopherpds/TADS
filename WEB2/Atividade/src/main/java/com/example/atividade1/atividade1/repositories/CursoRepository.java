package com.example.atividade1.atividade1.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atividade1.atividade1.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
        // Métodos para Listas Não Paginadas
        List<Curso> findByCategoriaId(Long categoriaId);
        List<Curso> findByNomeContainingIgnoreCase(String nome);
        
        // Métodos Paginados
        Page<Curso> findByCategoriaId(Long categoriaId, Pageable pageable);
        Page<Curso> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
}
