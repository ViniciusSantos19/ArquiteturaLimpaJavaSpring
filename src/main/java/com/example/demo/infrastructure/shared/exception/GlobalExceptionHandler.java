
package com.example.demo.infrastructure.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.core.domain.usuario.exceptions.UsuarioAlredyExistException;
import com.example.demo.infrastructure.delivery.responses.ProjectResponse;
import com.example.demo.infrastructure.shared.constants.CommonConstants;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(UsuarioAlredyExistException.class)
  public ResponseEntity<?> handleUsuarioAlredyExistException(UsuarioAlredyExistException ex, WebRequest request) {
    String errorMessage = "User already exists";
    return new ResponseEntity<>(
        new ProjectResponse<>(CommonConstants.FAILURE, String.valueOf(HttpStatus.CONFLICT), errorMessage),
        HttpStatus.CONFLICT);
  }

  @ExceptionHandler(ProjectException.class)
  public ResponseEntity<?> handleProjectException(ProjectException ex, WebRequest request) {
    String errorMessage = ex.getMessage();
    return new ResponseEntity<>(
        new ProjectResponse<>(CommonConstants.FAILURE, String.valueOf(HttpStatus.BAD_REQUEST), errorMessage),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
    String errorMessage = ex.getMessage() + " " + ex.getClass().getName();
    return new ResponseEntity<>(
        new ProjectResponse<>(CommonConstants.FAILURE, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR),
            errorMessage),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
