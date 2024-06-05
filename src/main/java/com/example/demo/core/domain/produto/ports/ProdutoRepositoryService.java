package com.example.demo.core.domain.produto.ports;

import java.util.Optional;

import com.example.demo.core.domain.produto.Produto;
import com.example.demo.core.domain.produto.exceptions.ProdutoNotFoundException;

/**
 * ProdutoRepositoryService
 */
public interface ProdutoRepositoryService {

  public Optional<Produto> findById(Long id);

  public void delete(Long id) throws ProdutoNotFoundException;

  public void save(Produto produto);

}
