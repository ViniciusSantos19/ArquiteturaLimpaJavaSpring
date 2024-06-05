package com.example.demo.core.domain.usuario.useCases;

import com.example.demo.core.domain.usuario.exceptions.UserNotFoundException;

public interface DeleteUsuarioUseCase {
	public void delete(Long id) throws UserNotFoundException;
}
