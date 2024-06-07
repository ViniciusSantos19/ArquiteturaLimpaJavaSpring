package com.example.demo.infrastructure.delivery.impls;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.core.domain.produto.exceptions.ProdutoAlredyExistsExceptoin;
import com.example.demo.core.domain.produto.exceptions.ProdutoNotFoundException;
import com.example.demo.core.domain.produto.useCases.impls.ConsultarProdutosUseCaseImpl;
import com.example.demo.core.domain.produto.useCases.impls.CreateProdutoUseCaseImpl;
import com.example.demo.core.domain.produto.useCases.impls.DeleteProdutoUseCaseImpl;
import com.example.demo.core.domain.produto.useCases.impls.UpdateProdutoUseCaseImpl;
import com.example.demo.infrastructure.delivery.ProdutoController;
import com.example.demo.infrastructure.delivery.converters.ProdutoRestConverter;
import com.example.demo.infrastructure.delivery.dtos.ProdutoDto;
import com.example.demo.infrastructure.delivery.responses.ProjectResponse;
import com.example.demo.infrastructure.shared.constants.CommonConstants;
import com.example.demo.infrastructure.shared.exception.ProjectException;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ProdutoControllerImpl
 */
@RequestMapping("/produtos")
@RestController
@RequiredArgsConstructor
public class ProdutoControllerImpl implements ProdutoController {

  private static final Logger logger = LoggerFactory.getLogger(ProdutoController.class);

  private final CreateProdutoUseCaseImpl createProdutoUseCaseImpl;
  private final ConsultarProdutosUseCaseImpl consultarProdutosUseCaseImpl;
  private final UpdateProdutoUseCaseImpl updateProdutoUseCaseImpl;
  private final DeleteProdutoUseCaseImpl deleteProdutoUseCaseImpl;
  private final ProdutoRestConverter produtoRestConverter;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  @Override
  public ProjectResponse<Boolean> criarProduto(@RequestBody ProdutoDto produtoDto) {
    logger.info("Received request to create product: {}", produtoDto);

    try {
      this.createProdutoUseCaseImpl.create(this.produtoRestConverter.mapToEntity(produtoDto));
    } catch (ProdutoAlredyExistsExceptoin e) {
      logger.error("Error creating product: {}", e.getMessage());
      return new ProjectResponse<>(
          CommonConstants.FAILURE,
          String.valueOf(HttpStatus.CONFLICT.value()),
          "Product already exists");
    }

    logger.info("Product created successfully: {}", produtoDto);
    return new ProjectResponse<>(
        HttpStatus.CREATED.toString(),
        String.valueOf(HttpStatus.CREATED.value()),
        CommonConstants.OK,
        true);
  }

  @Override
  @ResponseStatus(HttpStatus.OK)
  @GetMapping()
  public ProjectResponse<Collection<ProdutoDto>> getAllProdutos() {
    Collection<ProdutoDto> produtos = consultarProdutosUseCaseImpl.getAllProdutos().stream()
        .map(produtoRestConverter::mapRoRest).collect(Collectors.toList());
    return new ProjectResponse<>(HttpStatus.OK.toString(), String.valueOf(HttpStatus.OK.value()), CommonConstants.OK,
        produtos);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Override
  public ProjectResponse<Boolean> deletarProdto(@PathVariable Long id) throws ProjectException {
    try {
      deleteProdutoUseCaseImpl.delete(id);
    } catch (ProdutoNotFoundException e) {
      return new ProjectResponse<>(HttpStatus.NOT_FOUND.toString(), String.valueOf(HttpStatus.NOT_FOUND.value()),
          CommonConstants.FAILURE, false);
    }
    return new ProjectResponse<>(HttpStatus.NO_CONTENT.toString(), String.valueOf(HttpStatus.NO_CONTENT.value()),
        CommonConstants.OK, true);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @Override
  public ProjectResponse<Boolean> atualizarProduto(@RequestBody ProdutoDto produtoDto, @PathVariable Long id)
      throws ProjectException {
    try {
      updateProdutoUseCaseImpl.update(produtoRestConverter.mapToEntity(produtoDto), id);
    } catch (ProdutoNotFoundException e) {
      return new ProjectResponse<>(HttpStatus.NOT_FOUND.toString(), String.valueOf(HttpStatus.NOT_FOUND.value()),
          CommonConstants.FAILURE, false);

    }
    return new ProjectResponse<>(HttpStatus.OK.toString(), String.valueOf(HttpStatus.OK.value()), CommonConstants.OK,
        true);
  }

}
