package com.algamoney.algamoney.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algamoney.algamoney.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}
