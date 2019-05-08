package com.algamoney.algamoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algamoney.algamoney.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
}
