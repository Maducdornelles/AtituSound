package br.edu.atitus.atitusound.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.edu.atitus.atitusound.entities.UserEntity;

public interface UserService extends GenericService<UserEntity> , UserDetailsService{

	
}
