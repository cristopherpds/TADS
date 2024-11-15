package com.example.atividade1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividade1.models.ProfessorModel;
import com.example.atividade1.repositories.ProfessorRepository;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public ProfessorModel findByEmail(String email) {
        return professorRepository.findByEmail(email);
    }

    public List<ProfessorModel> findAll() {
        return professorRepository.findAll();
    }

    public ProfessorModel findById(Long id) {
        return professorRepository.findById(id).orElseThrow(() -> new RuntimeException("Professor not found"));
    }

    public ProfessorModel save(ProfessorModel professor) {
        return professorRepository.save(professor);
    }

    public ProfessorModel update(Long id, ProfessorModel professor) {
        ProfessorModel existingProfessor = professorRepository.findById(id).orElseThrow(() -> new RuntimeException("Professor not found"));
        existingProfessor.setNome(professor.getNome());
        existingProfessor.setEmail(professor.getEmail());
        existingProfessor.setFoto(professor.getFoto());
        return professorRepository.save(existingProfessor);
    }

    public void delete(Long id) {
        professorRepository.deleteById(id);
    }
}