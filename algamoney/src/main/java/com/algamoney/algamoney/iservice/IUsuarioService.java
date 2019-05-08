package com.algamoney.algamoney.iservice;

import java.util.List;

import com.algamoney.algamoney.model.User;

public interface IUsuarioService {

	User getOne(Long id);

	List<User> findAll();

	User save(User user);
}
