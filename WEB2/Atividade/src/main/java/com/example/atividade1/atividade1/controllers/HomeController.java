package com.example.atividade1.atividade1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.atividade1.atividade1.models.Categoria;
import com.example.atividade1.atividade1.models.Curso;
import com.example.atividade1.atividade1.services.CategoriaService;
import com.example.atividade1.atividade1.services.CursoService;

@Controller
public class HomeController {
    @Autowired
    private CursoService cursoService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public String home(Model model, @RequestParam(defaultValue = "0") int page) {
        int pageSize = 6;
        List<Curso> cursos = cursoService.findAll();
        List<Categoria> categorias = categoriaService.findAll();
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Curso> paginaCursos = cursoService.findAll(pageable);
        model.addAttribute("paginaCursos", paginaCursos);
        model.addAttribute("cursos", paginaCursos.getContent());
        model.addAttribute("categorias", categorias);
        return "index";
    }
}
