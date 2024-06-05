package com.example.demo.core.domain.usuario.useCases.impls;

import com.example.demo.core.domain.usuario.Usuario;
import com.example.demo.core.domain.usuario.exceptions.UsuarioAlredyExistException;
import com.example.demo.core.domain.usuario.ports.UserRepositoryService;
import com.example.demo.core.domain.usuario.useCases.CriarUsuairoUseCase;

import lombok.AllArgsConstructor;

/**
 * CriarUsuarioUseCaseImpl
 */
@AllArgsConstructor
public class CriarUsuarioUseCaseImpl implements CriarUsuairoUseCase {

  private UserRepositoryService userRepositoryService;

  @Override
  public void execute(Usuario usuario) throws UsuarioAlredyExistException {
    if (this.userRepositoryService.doesUsuarioExistByName(usuario.getNome())) {
      throw new UsuarioAlredyExistException();
    }
    this.userRepositoryService.save(usuario);
  }
}
