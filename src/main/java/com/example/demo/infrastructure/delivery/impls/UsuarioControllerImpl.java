package com.example.demo.infrastructure.delivery.impls;

import java.util.Collection;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.core.domain.usuario.exceptions.UsuarioAlredyExistException;
import com.example.demo.core.domain.usuario.useCases.impls.CriarUsuarioUseCaseImpl;
import com.example.demo.core.domain.usuario.useCases.impls.FindAllUsuariosUseCaseImpl;
import com.example.demo.infrastructure.delivery.UsuarioController;
import com.example.demo.infrastructure.delivery.converters.UsuarioRestConverter;
import com.example.demo.infrastructure.delivery.dtos.UsuarioDto;
import com.example.demo.infrastructure.delivery.responses.ProjectResponse;
import com.example.demo.infrastructure.shared.constants.CommonConstants;
import com.example.demo.infrastructure.shared.exception.ProjectException;

import lombok.RequiredArgsConstructor;

/**
 * UsuarioController
 */
@RequestMapping("/usuarios")
@RestController
@RequiredArgsConstructor
public class UsuarioControllerImpl implements UsuarioController {

  private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

  private final FindAllUsuariosUseCaseImpl findAllUsuariosUseCaseImpl;
  private final CriarUsuarioUseCaseImpl criarUsuarioUseCaseImpl;
  private final UsuarioRestConverter restConverter;

  @Override
  @ResponseStatus(HttpStatus.OK)
  @GetMapping()
  public ProjectResponse<Collection<UsuarioDto>> getAllUsuarios() throws ProjectException {
    Collection<UsuarioDto> usuarios = findAllUsuariosUseCaseImpl.getAllUsuarios().stream()
        .map(usuario -> restConverter.mapRoRest(usuario)) // Certifique-se de que o método é mapToRest e não mapRoRest
        .collect(Collectors.toList());

    return new ProjectResponse<>(
        CommonConstants.SUCCESS,
        String.valueOf(HttpStatus.OK),
        CommonConstants.OK,
        usuarios);
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping
  @Override
  public ProjectResponse<Boolean> criarUsuario(@RequestBody UsuarioDto usuario) throws ProjectException {
    logger.info("Received request to create product: {}", usuario);
    try {
      this.criarUsuarioUseCaseImpl.execute(this.restConverter.mapToEntity(usuario));
    } catch (UsuarioAlredyExistException e) {
      logger.error("Error creating usuario: {}", e.getMessage());
      return new ProjectResponse<>(CommonConstants.FAILURE, String.valueOf(HttpStatus.CONFLICT), "User already exists");
    }
    logger.info("Product created successfully: {}", usuario);
    return new ProjectResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK);
  }

}
