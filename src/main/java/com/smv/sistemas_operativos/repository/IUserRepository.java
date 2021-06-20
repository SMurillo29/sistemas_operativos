package com.smv.sistemas_operativos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smv.sistemas_operativos.models.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
	User findByDocumento(String documento);
}
