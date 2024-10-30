package com.example.atividade1.atividade1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividade1.atividade1.interfaces.CursoService;
import com.example.atividade1.atividade1.models.Curso;
import com.example.atividade1.atividade1.repositories.CursoRepository;


@Service
public class CursoServiceImpl implements CursoService{
    

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
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
