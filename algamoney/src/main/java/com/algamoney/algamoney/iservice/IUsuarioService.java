package com.algamoney.algamoney.iservice;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.algamoney.algamoney.model.Usuario;

public interface IUsuarioService {

	List<Usuario> findAll();

	Usuario save(Usuario usuario);

	Usuario findOne(Long id);

}
 