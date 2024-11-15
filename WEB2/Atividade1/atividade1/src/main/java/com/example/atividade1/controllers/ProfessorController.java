package com.example.atividade1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.atividade1.ProfessorDetails;
import com.example.atividade1.models.ProfessorModel;
import com.example.atividade1.services.ProfessorService;

@Controller
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping("/professores")
    public String listarProfessores(Model model) {
        List<ProfessorModel> professores = professorService.findAll();
        model.addAttribute("professores", professores);
        return "professores";
    }

    @GetMapping("/professores/novo")
    public String novoProfessorForm(Model model) {
        model.addAttribute("professor", new ProfessorModel());
        return "formProfessor";
    }

    @PostMapping("/professores")
    public String criarProfessor(@ModelAttribute ProfessorModel professor) {
        if (!isAdmin()) {
            return "redirect:/professores?error=not_authorized";
        }
        professorService.save(professor);
        return "redirect:/professores";
    }

    @GetMapping("/professores/{id}/editar")
    public String editarProfessorForm(@PathVariable Long id, Model model) {
        ProfessorModel professor = professorService.findById(id);
        model.addAttribute("professor", professor);
        return "formProfessor";
    }

    @PostMapping("/professores/{id}")
    public String atualizarProfessor(@PathVariable Long id, @ModelAttribute ProfessorModel professor) {
        professorService.update(id, professor);
        return "redirect:/professores";
    }

    @PostMapping("/professores/{id}/deletar")
    public String deletarProfessor(@PathVariable Long id) {
        if (!isAdmin()) {
            return "redirect:/professores?error=not_authorized";
        }
        professorService.delete(id);
        return "redirect:/professores";
    }

    private boolean isAdmin() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof ProfessorDetails) {
            ProfessorDetails userDetails = (ProfessorDetails) principal;
            return userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        }
        return false;
    }
}