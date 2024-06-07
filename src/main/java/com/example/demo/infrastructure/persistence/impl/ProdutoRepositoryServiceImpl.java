package com.example.demo.infrastructure.persistence.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.core.domain.produto.Produto;
import com.example.demo.core.domain.produto.exceptions.ProdutoNotFoundException;
import com.example.demo.core.domain.produto.ports.ProdutoRepositoryService;
import com.example.demo.infrastructure.persistence.converters.ProdutoRepositoryConverter;
import com.example.demo.infrastructure.persistence.repositories.ProdutoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AllArgsConstructor;

/**
 * ProdutoRepositoryServiceImpl
 */
@AllArgsConstructor
public class ProdutoRepositoryServiceImpl implements ProdutoRepositoryService {
  private final static Logger logger = LoggerFactory.getLogger(ProdutoRepositoryService.class);

  private final ProdutoRepository produtoRepository;
  private final ProdutoRepositoryConverter produtoRepositoryConverter;

  @Override
  public Optional<Produto> findById(Long id) {
    return produtoRepository.findById(id)
        .map(produtoRepositoryConverter::mapToEntity);
  }

  @Override
  public Collection<Produto> findByNome(String nome) {
    return produtoRepository.findByNome(nome).stream().map(produtoRepositoryConverter::mapToEntity)
        .collect(Collectors.toList());
  }

  @Override
  public Collection<Produto> findByCategoria(String categoria) {
    return produtoRepository.findByCategoria(categoria).stream().map(produtoRepositoryConverter::mapToEntity)
        .collect(Collectors.toList());

  }

  @Override
  public void delete(Long id) throws ProdutoNotFoundException {
    var optionalProduto = produtoRepository.findById(id);
    if (optionalProduto.isEmpty()) {
      throw new ProdutoNotFoundException("Produto não encontrado");
    }
    this.produtoRepository.deleteById(id);
  }

  @Override
  public void save(Produto produto) {
    var produtoEnitity = produtoRepositoryConverter.mapToTable(produto);
    logger.info("Produot entity: {}", produtoEnitity);
    this.produtoRepository.save(produtoEnitity);
  }

  @Override
  public Collection<Produto> findByPreco(BigDecimal preco) {
    return produtoRepository.findByPreco(preco).stream().map(produtoRepositoryConverter::mapToEntity)
        .collect(Collectors.toList());
  }

  @Override
  public Collection<Produto> findAll() {
    return this.produtoRepository.findAll().stream().map(produtoRepositoryConverter::mapToEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void update(Produto produto, Long id) throws ProdutoNotFoundException {
    var optionalProduto = produtoRepository.findById(id);
    if (optionalProduto.isEmpty()) {
      throw new ProdutoNotFoundException("Produto não encontrado");
    }
    var produtoAtualizado = optionalProduto.get();
    produtoAtualizado.setNome(produto.getNome());
    produtoAtualizado.setDescricao(produto.getDescricao());
    produtoAtualizado.setPreco(produto.getPreco());
    produtoAtualizado.setQuantidadeEstoque(produto.getQuantidadeEstoque());
    produtoAtualizado.setCategoria(produto.getCategoria());
    this.produtoRepository.save(produtoAtualizado);
  }
}
