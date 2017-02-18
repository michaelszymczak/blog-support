package com.michaelszymczak.blogsupport.coati;

import com.michaelszymczak.blogsupport.coati.support.Value;

public class Ticker extends Value {
  private final String code;

  public Ticker(String code) {
    this.code = code;
  }
}
