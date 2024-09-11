package com.ExemploAula.controller;


import java.util.Optional;

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

import com.ExemploAula.dto.CategoriaDTO;
import com.ExemploAula.model.CategoriaModel;
import com.ExemploAula.repositories.CategoriaRespository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    CategoriaRespository repository;

    @GetMapping("/")
    public String index() {
        return "categoria/index";
    }

    @GetMapping("/inserir/")
    public String inserir() {
        return "categoria/inserir";
    }

    @PostMapping("/inserir/")
    public String inserirDB(@ModelAttribute @Valid CategoriaDTO categoriaDTO, BindingResult result, RedirectAttributes msg) {
        if(result.hasErrors()) {
            msg.addFlashAttribute("erroCadastrar", "Erro ao cadastrar nova categoria");
            return "redirect:/categoria/inserir/";
        }

        var categoriaModel = new CategoriaModel();
        BeanUtils.copyProperties(categoriaDTO, categoriaModel);
        repository.save(categoriaModel);
        msg.addFlashAttribute("sucessoCadastrar", "Categoria cadastrada!");
        return "redirect:../";
        
    }

    @GetMapping("/listar/")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("categoria/listar");
        mv.addObject("categorias", repository.findAll());
        return mv;
        
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable(value = "id") int id){
        ModelAndView mv = new ModelAndView("/categoria/editar");
        Optional<CategoriaModel> categoria =  repository.findById(id);
        if(categoria.isPresent()){
            mv.addObject("categoria", categoria.get());
        }

        return mv;

    }

    @PostMapping("/editar/{id}")
    public String editarCategoria(RedirectAttributes msg, @PathVariable(value="id") int id, @Valid CategoriaDTO categoriaDTO, BindingResult result){
        Optional<CategoriaModel> categoriaOpt = repository.findById(id);

        if(!categoriaOpt.isPresent()){
            msg.addFlashAttribute("erroEditar", "Erro ao editar categoria");
            return "redirect:/categoria/listar/";
        }

        if(result.hasErrors()){
            System.out.println(result.toString());
            msg.addFlashAttribute("erroEditar", "Erro ao editar categoria");
            return "redirect:/categoria/listar/";
        }

        CategoriaModel categoriaModel = categoriaOpt.get();
        BeanUtils.copyProperties(categoriaDTO, categoriaModel);
        repository.save(categoriaModel);
        msg.addFlashAttribute("sucessoEditar", "Categoria editada!");
        return "redirect:../../categoria/listar/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") int id){
        Optional<CategoriaModel> categoria = repository.findById(id);
        if(categoria.isEmpty()){
            return "redirect:/categoria/listar/";
        }

        repository.deleteById(id);
        return "redirect:/categoria/listar/";
    }
}
