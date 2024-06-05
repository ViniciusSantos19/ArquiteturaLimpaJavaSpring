package com.example.demo.core.domain.usuario.useCases;

import java.util.Optional;

import com.example.demo.core.domain.usuario.Usuario;
import com.example.demo.core.domain.usuario.exceptions.UserNotFoundException;

public interface FindUsuarioByIdUseCase {
	public Optional<Usuario> findById(Long id) throws UserNotFoundException;
}
