package com.example.demo.infrastructure.persistence.converters;

import org.springframework.stereotype.Component;

import com.example.demo.core.domain.usuario.Usuario;
import com.example.demo.infrastructure.persistence.entities.UsuarioEntity;
import com.example.demo.infrastructure.shared.RepositoryConverter;

/**
 * UsuarioRepositoryConverter
 */
@Component
public class UsuarioRepositoryConverter implements RepositoryConverter<UsuarioEntity, Usuario> {
  @Override
  public UsuarioEntity mapToTable(Usuario persistenceObject) {
    return new UsuarioEntity(persistenceObject.getId(),
        persistenceObject.getNome(),
        persistenceObject.getEmail(),
        persistenceObject.getPassword());
  }

  @Override
  public Usuario mapToEntity(UsuarioEntity tableObject) {
    return new Usuario(tableObject.getId(),
        tableObject.getNome(),
        tableObject.getEmail(),
        tableObject.getSenha());
  }
}
