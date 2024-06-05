package com.example.demo.infrastructure.persistence.converters;

import com.example.demo.core.domain.produto.Produto;
import com.example.demo.infrastructure.persistence.entities.ProdutoEntity;
import com.example.demo.infrastructure.shared.RepositoryConverter;

/**
 * ProdutoRepositoryConverter
 */
public class ProdutoRepositoryConverter implements RepositoryConverter<ProdutoEntity, Produto> {
  @Override
  public ProdutoEntity mapToTable(Produto persistenceObject) {
    return new ProdutoEntity(persistenceObject.getId(),
        persistenceObject.getNome(),
        persistenceObject.getDescricao(),
        persistenceObject.getPreco(),
        persistenceObject.getQuantidadeEstoque(),
        persistenceObject.getCategoria());
  }

  @Override
  public Produto mapToEntity(ProdutoEntity tableObject) {
    return new Produto(tableObject.getId(),
        tableObject.getNome(),
        tableObject.getDescricao(),
        tableObject.getPreco(),
        tableObject.getQuantidadeEstoque(),
        tableObject.getCategoria());
  }
}
