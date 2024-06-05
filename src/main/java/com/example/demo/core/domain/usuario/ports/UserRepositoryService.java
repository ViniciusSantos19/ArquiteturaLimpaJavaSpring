package com.example.demo.core.domain.usuario.ports;

import java.util.Collection;
import java.util.Optional;

import com.example.demo.core.domain.usuario.Usuario;
import com.example.demo.core.domain.usuario.exceptions.UserNotFoundException;
import com.example.demo.core.domain.usuario.exceptions.UsuarioAlredyExistException;

public interface UserRepositoryService {
  public Optional<Usuario> findUsuarioById(long id) throws UserNotFoundException;

  public void save(Usuario usuario) throws UsuarioAlredyExistException;

  public void delete(Long id) throws UserNotFoundException;

  public Collection<Usuario> getAllUsers();

  public Boolean doesUsuarioExistByName(String nome);
}
