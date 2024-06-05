package com.example.demo.infrastructure.shared.exception;

import org.springframework.http.HttpStatus;

/**
 * NotFoudException
 */
public class NotFoudException extends ProjectException {
  private static final long serialVersionUID = -6870732210014274010L;

  public NotFoudException(final String message) {
    super(HttpStatus.NOT_FOUND.value(), message);
  }

}
