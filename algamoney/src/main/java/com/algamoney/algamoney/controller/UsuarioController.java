package com.algamoney.algamoney.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.algamoney.algamoney.iservice.IUsuarioService;
import com.algamoney.algamoney.model.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	private IUsuarioService usuarioService;
	private ApplicationEventPublisher applicationEventPublisher;
	
	@Autowired
	public UsuarioController(IUsuarioService usuarioService, ApplicationEventPublisher applicationEventPublisher) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public List<Usuario> findAll() {
		return usuarioService.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Usuario> salvar (@RequestBody Usuario usuario, HttpServletResponse response) {
		Usuario savedUsuario = usuarioService.save(usuario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(savedUsuario.getId()).toUri();
		
		return ResponseEntity.created(uri).body(savedUsuario);
	}
	
	@GetMapping("/{id}")
	public Usuario findOne(@PathVariable("id") Long id) {
		return usuarioService.findOne(id);
	}

}
