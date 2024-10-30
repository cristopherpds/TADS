package com.example.atividade1.atividade1.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.atividade1.atividade1.models.Curso;
import com.example.atividade1.atividade1.services.CategoriaService;
import com.example.atividade1.atividade1.services.CursoService;
import com.example.atividade1.atividade1.services.FileStorageService;
import com.example.atividade1.atividade1.services.ProfessorService;

@Controller
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService cursoService;
    private final ProfessorService professorService;
    private final CategoriaService categoriaService;

    @Autowired
    public CursoController(CursoService cursoService, ProfessorService professorService,
            CategoriaService categoriaService) {
        this.cursoService = cursoService;
        this.professorService = professorService;
        this.categoriaService = categoriaService;
    }

    @Autowired
    private FileStorageService fileStorageService;

   

    @GetMapping
    public String listarCursos(Model model) {
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        return "cursos/lista";
    }

    @GetMapping("/novo")
    public String novoCurso(Model model) {
        model.addAttribute("curso", new Curso());
        model.addAttribute("professores", professorService.findAll());
        model.addAttribute("categorias", categoriaService.findAll());
        return "cursos/form";
    }

    /* @PostMapping
    public String salvarCurso(@ModelAttribute Curso curso) {
        cursoService.save(curso);
        return "redirect:/cursos";
    } */
    @PostMapping
    public String salvarCurso(@ModelAttribute Curso curso, @RequestParam("imagemFile") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String fileName = fileStorageService.storeFile(file);
                curso.setImagem(fileName);
            } catch (IOException e) {
                // Trate o erro adequadamente
            }
        }
        cursoService.save(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/{id}/editar")
    public String editarCurso(@PathVariable Long id, Model model) {
        Curso curso = cursoService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso inválido com id: " + id));
        model.addAttribute("curso", curso);
        model.addAttribute("professores", professorService.findAll());
        model.addAttribute("categorias", categoriaService.findAll());
        return "cursos/form";
    }

    @GetMapping("/{id}/excluir")
    public String excluirCurso(@PathVariable Long id) {
        cursoService.deleteById(id);
        return "redirect:/cursos";
    }

    @GetMapping("/categoria/{id}")
    public String listarCursosPorCategoria(@PathVariable Long id, Model model) {
        List<Curso> cursos = cursoService.findByCategoriaId(id);
        model.addAttribute("cursos", cursos);
        return "cursos/lista";
    }

    @GetMapping("/buscar")
    public String buscarCursos(@RequestParam String nome, Model model) {
        List<Curso> cursos = cursoService.findByNomeContaining(nome);
        model.addAttribute("cursos", cursos);
        return "cursos/lista";
    }
}
