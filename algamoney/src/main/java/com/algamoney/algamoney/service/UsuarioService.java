package com.algamoney.algamoney.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.algamoney.algamoney.iservice.IUsuarioService;
import com.algamoney.algamoney.model.Usuario;
import com.algamoney.algamoney.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

	private UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario findOne(Long id) {
		Usuario savedUsuario = usuarioRepository.findById(id).get();
		return savedUsuario;
	}

}
