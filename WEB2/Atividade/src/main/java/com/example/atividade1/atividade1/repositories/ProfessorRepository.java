package com.example.atividade1.atividade1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atividade1.atividade1.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
