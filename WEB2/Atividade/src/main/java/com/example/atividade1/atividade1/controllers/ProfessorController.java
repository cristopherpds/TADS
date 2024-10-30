package com.example.atividade1.atividade1.controllers;

import java.io.IOException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.atividade1.atividade1.models.Professor;
import com.example.atividade1.atividade1.services.FileStorageService;
import com.example.atividade1.atividade1.services.ProfessorService;



@Controller
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorService professorService;
    private final FileStorageService fileStorageService;


    public ProfessorController(ProfessorService professorService, FileStorageService fileStorageService) {
        this.professorService = professorService;
        this.fileStorageService = fileStorageService;
    }



    @GetMapping
    public String listarProfessores(Model model, @RequestParam(defaultValue = "0") int page) {
        int pageSize = 7;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Professor> paginaProfessores = professorService.findAll(pageable);
        model.addAttribute("paginaProfessores", paginaProfessores);
        return "professores/lista";
    }

    @GetMapping("/novo")
    public String novoProfessor(Model model) {
        model.addAttribute("professor", new Professor());
        return "professores/form";
    }

    /* @PostMapping
    public String salvarProfessor(@ModelAttribute Professor professor) {
        professorService.save(professor);
        return "redirect:/professores";
    } */
    @PostMapping
    public String salvarProfessor(@ModelAttribute Professor professor, @RequestParam("fotoFile") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String fileName = fileStorageService.storeFile(file);
                professor.setFoto(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        professorService.save(professor);
        return "redirect:/professores";
    }

    @GetMapping("/{id}/editar")
    public String editarProfessor(@PathVariable Long id, Model model) {
        Professor professor = professorService.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Professor inválido com id: " + id));
        model.addAttribute("professor", professor);
        return "professores/form";
    }

    @PostMapping("/{id}/excluir")
    public String excluirProfessor(@PathVariable Long id) {
        professorService.deleteById(id);
        return "redirect:/professores";
    }
    
}
