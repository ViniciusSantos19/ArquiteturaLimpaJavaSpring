package com.example.demo.infrastructure.delivery.converters;

import com.example.demo.core.domain.produto.Produto;
import com.example.demo.infrastructure.delivery.dtos.ProdutoDto;
import com.example.demo.infrastructure.shared.RestConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ProdutoRestConverter
 */
public class ProdutoRestConverter implements RestConverter<ProdutoDto, Produto> {

  private static final Logger logger = LoggerFactory.getLogger(ProdutoRestConverter.class);

  @Override
  public Produto mapToEntity(ProdutoDto rest) {
    Produto produto = new Produto(null, rest.nome(), rest.descricao(),
        rest.preco(),
        rest.quantidadeEstoque(),
        rest.categoria());
    logger.info("Mapped ProdutoDto to Produto: {}", produto);
    return produto;
  }

  @Override
  public ProdutoDto mapRoRest(Produto entiry) {
    ProdutoDto produtoDto = new ProdutoDto(entiry.getNome(), entiry.getDescricao(), entiry.getPreco(),
        entiry.getQuantidadeEstoque(),
        entiry.getCategoria());
    logger.info("Mapped Produto to ProdutoDto: {}", produtoDto);
    return produtoDto;
  }
}
