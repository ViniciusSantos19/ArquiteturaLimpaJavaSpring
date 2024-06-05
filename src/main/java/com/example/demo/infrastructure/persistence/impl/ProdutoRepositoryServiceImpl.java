package com.example.demo.infrastructure.persistence.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

import com.example.demo.core.domain.produto.Produto;
import com.example.demo.core.domain.produto.ports.ProdutoRepositoryService;
import com.example.demo.infrastructure.persistence.converters.ProdutoRepositoryConverter;
import com.example.demo.infrastructure.persistence.repositories.ProdutoRepository;

import lombok.AllArgsConstructor;

/**
 * ProdutoRepositoryServiceImpl
 */
@AllArgsConstructor
public class ProdutoRepositoryServiceImpl implements ProdutoRepositoryService {

  private final ProdutoRepository produtoRepository;
  private final ProdutoRepositoryConverter produtoRepositoryConverter;

  @Override
  public Optional<Produto> findById(Long id) {
    // TODO Auto-generated method stub
    return Optional.empty();
  }

  @Override
  public Collection<Produto> findByNome(String nome) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Collection<Produto> findByCategoria(String categoria) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void delete(Long id) {
    // TODO Auto-generated method stub

  }

  @Override
  public void save(Produto produto) {
    // TODO Auto-generated method stub

  }

  @Override
  public Collection<Produto> findByPreco(BigDecimal preco) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Collection<Produto> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void update(Produto produto, Long id) {
    // TODO Auto-generated method stub

  }
}
