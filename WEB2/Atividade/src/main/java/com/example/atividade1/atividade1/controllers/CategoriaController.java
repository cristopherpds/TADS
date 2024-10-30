package com.example.atividade1.atividade1.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.atividade1.atividade1.models.Categoria;
import com.example.atividade1.atividade1.services.CategoriaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;


    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listarCategorias(Model model,  @RequestParam(defaultValue = "0") int page) {
        int pageSize = 7;
        List<Categoria> categorias = categoriaService.findAll();
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Categoria> paginaCategorias = categoriaService.findAll(pageable);
        model.addAttribute("paginaCategorias", paginaCategorias);
        model.addAttribute("categorias", categorias);
        return "categorias/lista";
    }

    @GetMapping("/novo")
    public String novaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/form";
    }

    @PostMapping
    public String salvarCategoria(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
        if (result.hasErrors()) {
            return "categorias/form";
        }
        categoriaService.save(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/{id}/editar")
    public String editarCategoria(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Categoria inválida com id: " + id));
        model.addAttribute("categoria", categoria);
        return "categorias/form";
    }

    @PostMapping("/{id}/excluir")
    public String excluirCategoria(@PathVariable Long id) {
        categoriaService.deleteById(id);
        return "redirect:/categorias";
    }

}
