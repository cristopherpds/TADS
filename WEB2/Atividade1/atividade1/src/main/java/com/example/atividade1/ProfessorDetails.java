package com.example.atividade1;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.atividade1.models.ProfessorModel;

public class ProfessorDetails implements UserDetails{
    private ProfessorModel professor;

    public ProfessorDetails(ProfessorModel professor) {
        this.professor = professor;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(professor.getRole()));
    }

    @Override
    public String getPassword() {
        return professor.getPassword();
    }

    @Override
    public String getUsername() {
        return professor.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
