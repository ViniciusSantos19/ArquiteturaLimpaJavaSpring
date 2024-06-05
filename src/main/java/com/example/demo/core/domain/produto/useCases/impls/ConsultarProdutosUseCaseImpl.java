package com.example.demo.core.domain.produto.useCases.impls;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

import com.example.demo.core.domain.produto.Produto;
import com.example.demo.core.domain.produto.exceptions.ProdutoNotFoundException;
import com.example.demo.core.domain.produto.ports.ProdutoRepositoryService;
import com.example.demo.core.domain.produto.useCases.ConsultarProdutosUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConsultarProdutosUseCaseImpl implements ConsultarProdutosUseCase {

  private final ProdutoRepositoryService produtoRepositoryService;

  @Override
  public Optional<Produto> findProdutoById(Long id) throws ProdutoNotFoundException {
    var optionalProduto = this.produtoRepositoryService.findById(id);
    if (optionalProduto.isEmpty()) {
      throw new ProdutoNotFoundException("O produto com o id:" + id + "  não foi achado");
    }
    return optionalProduto;
  }

  @Override
  public Collection<Produto> getAllProdutos() {
    return produtoRepositoryService.findAll();
  }

  @Override
  public Collection<Produto> findProdutosByNome(String nome) throws ProdutoNotFoundException {
    Collection<Produto> produtos = produtoRepositoryService.findByNome(nome);
    if (produtos.isEmpty()) {
      throw new ProdutoNotFoundException("No products found with name: " + nome);
    }
    return produtos;
  }

  @Override
  public Collection<Produto> findProdutoByPreco(BigDecimal preco) throws ProdutoNotFoundException {
    Collection<Produto> produtos = produtoRepositoryService.findByPreco(preco);
    if (produtos.isEmpty()) {
      throw new ProdutoNotFoundException("No products found with price: " + preco);
    }
    return produtos;
  }

  @Override
  public Collection<Produto> findByCategoria(String categoria) throws ProdutoNotFoundException {
    Collection<Produto> produtos = produtoRepositoryService.findByCategoria(categoria);
    if (produtos.isEmpty()) {
      throw new ProdutoNotFoundException("No products found in category: " + categoria);
    }
    return produtos;
  }
}
