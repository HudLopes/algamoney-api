package com.algamoney.algamoney.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algamoney.algamoney.iservice.IUsuarioService;
import com.algamoney.algamoney.model.User;
import com.algamoney.algamoney.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private IUsuarioService usuarioService;
			
	@GetMapping
	public List<User> buscarTodos(){
		return usuarioService.findAll();
	}
	
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<?> buscar(@PathVariable Long id) {
		User user = usuarioService.getOne(id);
		return user != null ? ResponseEntity.ok().body(user) : ResponseEntity.notFound().build();
	}

	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user, HttpServletResponse response) {
		User userSalvo = usuarioService.save(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
		.buildAndExpand(userSalvo.getId()).toUri();
		response.setHeader("location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(userSalvo);
	}
	
}
