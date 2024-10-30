package com.example.atividade1.atividade1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.atividade1.atividade1.models.Categoria;
import com.example.atividade1.atividade1.services.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listarCategorias(Model model) {
        List<Categoria> categorias = categoriaService.findAll();
        model.addAttribute("categorias", categorias);
        return "categorias/lista";
    }

    @GetMapping("/novo")
    public String novaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/form";
    }

    @PostMapping
    public String salvarCategoria(@ModelAttribute Categoria categoria) {
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

    @GetMapping("/{id}/excluir")
    public String excluirCategoria(@PathVariable Long id) {
        categoriaService.deleteById(id);
        return "redirect:/categorias";
    }

}
