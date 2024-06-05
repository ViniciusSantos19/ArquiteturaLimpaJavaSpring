package com.example.demo.infrastructure.shared;

import java.io.Serializable;

public interface RestConverter<R extends Serializable, E extends Serializable> {

  default E mapToEntity(final R rest) {
    throw new UnsupportedOperationException();
  }

  default R mapRoRest(final E entiry) {
    throw new UnsupportedOperationException();
  }
}
