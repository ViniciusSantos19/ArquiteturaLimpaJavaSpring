package com.example.demo.core.domain.usuario.useCases;

import com.example.demo.core.domain.usuario.Usuario;
import com.example.demo.core.domain.usuario.exceptions.UsuarioAlredyExistException;

public interface CriarUsuairoUseCase {
	public void execute(Usuario usuario) throws UsuarioAlredyExistException;
}
