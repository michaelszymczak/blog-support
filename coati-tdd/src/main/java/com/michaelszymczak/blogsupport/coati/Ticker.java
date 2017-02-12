package com.michaelszymczak.blogsupport.coati;

import static com.google.common.base.Preconditions.checkNotNull;

public class Ticker extends Value {
  private final String code;

  public Ticker(String code) {
    this.code = checkNotNull(code);
  }
}
