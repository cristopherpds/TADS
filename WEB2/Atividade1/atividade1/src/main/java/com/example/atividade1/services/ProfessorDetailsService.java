package com.example.atividade1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.atividade1.ProfessorDetails;
import com.example.atividade1.models.ProfessorModel;
import com.example.atividade1.repositories.ProfessorRepository;

public class ProfessorDetailsService implements UserDetailsService {
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ProfessorModel professor = professorRepository.findByEmail(email);
        if (professor == null) {
            throw new UsernameNotFoundException("Professor not found");
        }
        professor.setPassword(passwordEncoder.encode(professor.getPassword()));
        return new ProfessorDetails(professor);
    }
}
