package com.algamoney.algamoney.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.algamoney.algamoney.iservice.IUsuarioService;
import com.algamoney.algamoney.model.User;
import com.algamoney.algamoney.repository.UserRepository;

public class UsuarioService implements IUsuarioService {
	private UserRepository userRepository;
	
	@Override
	public User getOne(Long id) {
		User savedUsuario = userRepository.getOne(id);

		if (savedUsuario == null) {
			throw new EmptyResultDataAccessException(1);
		}

		return savedUsuario;
	}


	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
