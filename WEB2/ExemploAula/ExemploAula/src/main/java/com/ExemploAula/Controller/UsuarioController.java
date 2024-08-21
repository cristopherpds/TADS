package com.ExemploAula.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ExemploAula.dto.UsuarioDTO;
import com.ExemploAula.model.UsuarioModel;
import com.ExemploAula.repositories.UsuarioRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioRepository repository;

    @GetMapping("/")
    public String index(){
        return "usuario/index";
    }

    @GetMapping("/inserir/")
    public String inserir(){
        return "usuario/inserir"; // Correspondendo ao arquivo inserir.html ou inserir.jsp
    }

    @PostMapping("/inserir/")
    public String inserirDB(@ModelAttribute @Valid UsuarioDTO usuarioDTO, BindingResult result, RedirectAttributes msg) {
        if(result.hasErrors()){
            msg.addFlashAttribute("ErroCadastrar", "Erro ao cadastrar novo usuario");
            return "redirect:/usuario/inserir";
        }
        var usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDTO, usuarioModel);
        usuarioModel.setTipo("comum");
        repository.save(usuarioModel);
        msg.addFlashAttribute("success", "Usuario cadastrado com sucesso");
        return "redirect:/usuario/inserir";
    }

}
