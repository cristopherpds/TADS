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
	public String index() {
		return "usuario/index";
	}

	@GetMapping("/inserir/")
	public String inserir() {
		return "usuario/inserir";
	}

	@PostMapping("/inserir/")
	public String inserirBD(
			@ModelAttribute @Valid UsuarioDTO usuarioDTO,
			BindingResult result, RedirectAttributes msg) {
		if (result.hasErrors()) {
			msg.addFlashAttribute("erroCadastrar", "Erro ao cadastrar novo usuário");
			return "redirect:/usuario/inserir/";
		}
		var usuarioModel = new UsuarioModel();
		BeanUtils.copyProperties(usuarioDTO, usuarioModel);
		usuarioModel.setTipo("comum");
		repository.save(usuarioModel);
		msg.addFlashAttribute("sucessoCadastrar", "Usuario cadastrado!");
		return "redirect:../";
	}

	// getmapping para listar los usuarios registrados
	@GetMapping("/listar/")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("usuario/listar");
		mv.addObject("usuarios", repository.findAll());
		return mv;
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable(value = "id") int id) {
		ModelAndView mv = new ModelAndView("usuario/editar");
		Optional<UsuarioModel> usuario = repository.findById(id);
		if (usuario.isPresent()) {
			mv.addObject("usuario", usuario.get());
		}
		return mv;
	}

	@PostMapping("/editar/{id}")
	public String editarUsuario(RedirectAttributes msg, @PathVariable(value="id") int id, @Valid UsuarioDTO usuarioDTO,
			BindingResult result) {
		Optional<UsuarioModel> usuarioOpt = repository.findById(id);

		if (!usuarioOpt.isPresent()) {
			msg.addFlashAttribute("erroEditar", "Usuário não encontrado");
			return "redirect:/usuario/listar1/";
		}

		if (result.hasErrors()) {
			msg.addFlashAttribute("erroEditar", "Erro ao editar usuário");
			return "redirect:/usuario/listar2/";
		}

		UsuarioModel usuarioModel = usuarioOpt.get();
		BeanUtils.copyProperties(usuarioDTO, usuarioModel);
		repository.save(usuarioModel);
		msg.addFlashAttribute("sucessoEditar", "Usuário atualizado com sucesso!");
		return "redirect:../../usuario/listar/";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") int id) {
		Optional<UsuarioModel> usuario = repository.findById(id);
		if (usuario.isEmpty()) {
			return "redirect:/usuario/listar/";
		}
		repository.deleteById(id);
		return "redirect:/usuario/listar/";
	}
}
