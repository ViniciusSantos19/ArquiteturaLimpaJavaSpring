package com.example.demo.infrastructure.shared.exception;

/**
 * ProjectException
 */
public abstract class ProjectException extends Exception {

  private static final long serialVersionUID = -7482635401716007171L;

  private final int code;

  public ProjectException(final int code, final String message) {
    super(message);
    this.code = code;
  }

  public int getCode() {
    return this.code;
  }

}
