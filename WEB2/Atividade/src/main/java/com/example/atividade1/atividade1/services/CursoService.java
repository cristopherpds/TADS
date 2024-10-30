package com.example.atividade1.atividade1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.atividade1.atividade1.models.Curso;

import com.example.atividade1.atividade1.repositories.CursoRepository;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    
    public List<Curso> findByCategoriaId(Long categoriaId) {
        return cursoRepository.findByCategoriaId(categoriaId);
    }

    public List<Curso> findByNomeContaining(String nome) {
        return cursoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }
    public Page<Curso> findAll(Pageable pageable) {
        return cursoRepository.findAll(pageable);
    }

    public Page<Curso> findByCategoriaId(Long categoriaId,  Pageable pageable) {
        return cursoRepository.findByCategoriaId(categoriaId, pageable);
    }

    public Page<Curso> findByNomeContaining(String nome,  Pageable pageable) {
        return cursoRepository.findByNomeContainingIgnoreCase(nome, pageable);
    }

    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }

}
