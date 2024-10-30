package com.example.atividade1.atividade1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividade1.atividade1.models.Professor;
import com.example.atividade1.atividade1.repositories.ProfessorRepository;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Optional<Professor> findById(Long id) {
        return professorRepository.findById(id);
    }

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public void deleteById(Long id) {
        professorRepository.deleteById(id);
    }

}
