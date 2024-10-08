package com.ExemploAula.controller;

import java.util.Optional;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ExemploAula.dto.ProdutoDTO;
import com.ExemploAula.model.CategoriaModel;
import com.ExemploAula.model.ProdutoModel;
import com.ExemploAula.repositories.CategoriaRespository;
import com.ExemploAula.repositories.ProdutoRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoRepository repository;

    @Autowired
    CategoriaRespository categoriaRepository;

    @GetMapping("/")
    public String index() {
        return "produto/index";
    }

    @GetMapping("/inserir/")
    public String inserir() {
        return "produto/inserir";
    }

    @PostMapping("/inserir")
    public String inserirDB(@ModelAttribute @Valid ProdutoDTO produtoDTO, BindingResult result,
            RedirectAttributes msg) {
        if (result.hasErrors()) {
            System.out.println(result.toString());
            msg.addFlashAttribute("erroCadastrar", "Erro ao cadastrar novo produto");
            return "redirect:/produto/inserir/";
        }

        var produtoModel = new ProdutoModel();
        System.out.println(produtoModel);
        BeanUtils.copyProperties(produtoDTO, produtoModel);

        CategoriaModel categoria = categoriaRepository.findById(produtoDTO.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        produtoModel.setCategoria(categoria);

        repository.save(produtoModel);
        msg.addFlashAttribute("sucessoCadastrar", "Produto cadastrado!");
        return "redirect:/produto/listar/";
    }

    @GetMapping("/inserir")
    public ModelAndView listarCategoria() {
        ModelAndView mv = new ModelAndView("produto/inserir");
        System.out.println(mv.toString());
        mv.addObject("categorias", categoriaRepository.findAll());
        return mv;
    }

    @GetMapping("/listar/")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("produto/listar");
        mv.addObject("produtos", repository.findAll());
        return mv;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable(value = "id") int id) {
        ModelAndView mv = new ModelAndView("/produto/editar");
        Optional<ProdutoModel> produto = repository.findById(id);
        if (produto.isPresent()) {
            mv.addObject("produtos", produto.get());

            Optional<CategoriaModel> categoria = categoriaRepository.findById(produto.get().getCategoria().getId());
            if (categoria.isPresent()) {
                mv.addObject("categorias", categoria.get());
            }
            List<CategoriaModel> categorias = categoriaRepository.findAll();
            mv.addObject("categorias", categorias);
        }

        return mv;

    }

}
