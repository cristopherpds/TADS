package com.example.atividade1.atividade1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.atividade1.atividade1.interfaces.CursoService;
import com.example.atividade1.atividade1.models.Curso;
import com.example.atividade1.atividade1.repositories.CursoRepository;


@Service
public class CursoServiceImpl implements CursoService{
    


    private CursoRepository cursoRepository;

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Page<Curso> findAll(Pageable pageable) {
        return cursoRepository.findAll(pageable);
    }

    @Override
    public Page<Curso> findByCategoriaId(Long categoriaId, Pageable pageable) {
        return cursoRepository.findByCategoriaId(categoriaId, pageable);
    }

    @Override
    public Page<Curso> findByNomeContaining(String nome, Pageable pageable) {
        return cursoRepository.findByNomeContainingIgnoreCase(nome, pageable);
    }

    @Override
    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public List<Curso> findByCategoriaId(Long categoriaId) {
        return cursoRepository.findByCategoriaId(categoriaId);
    }

    @Override
    public List<Curso> findByNomeContaining(String nome) {
        return cursoRepository.findByNomeContainingIgnoreCase(nome);
    }
}
