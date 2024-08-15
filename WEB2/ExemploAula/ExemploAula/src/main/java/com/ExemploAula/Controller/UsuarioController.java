package com.ExemploAula.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ExemploAula.Repositories.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioRepository repository;

    @GetMapping("/")
    public String index(){
        return "usuario/index";
    }
}
