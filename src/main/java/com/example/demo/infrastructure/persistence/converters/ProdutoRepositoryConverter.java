package com.example.demo.infrastructure.persistence.converters;

import com.example.demo.core.domain.produto.Produto;
import com.example.demo.infrastructure.persistence.entities.ProdutoEntity;
import com.example.demo.infrastructure.shared.RepositoryConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ProdutoRepositoryConverter
 */
public class ProdutoRepositoryConverter implements RepositoryConverter<ProdutoEntity, Produto> {

  private static final Logger logger = LoggerFactory.getLogger(ProdutoRepositoryConverter.class);

  @Override
  public ProdutoEntity mapToTable(Produto persistenceObject) {
    ProdutoEntity produtoEntity = new ProdutoEntity(
        persistenceObject.getId(),
        persistenceObject.getNome(),
        persistenceObject.getDescricao(),
        persistenceObject.getPreco(),
        persistenceObject.getQuantidadeEstoque(),
        persistenceObject.getCategoria());
    logger.info("Mapped Produto to ProdutoEntity: {}", produtoEntity);
    return produtoEntity;
  }

  @Override
  public Produto mapToEntity(ProdutoEntity tableObject) {
    Produto produto = new Produto(
        tableObject.getId(),
        tableObject.getNome(),
        tableObject.getDescricao(),
        tableObject.getPreco(),
        tableObject.getQuantidadeEstoque(),
        tableObject.getCategoria());
    logger.info("Mapped ProdutoEntity to Produto: {}", produto);
    return produto;
  }
}
