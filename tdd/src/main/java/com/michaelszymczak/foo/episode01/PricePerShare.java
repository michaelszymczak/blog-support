package com.michaelszymczak.foo.episode01;

public class PricePerShare extends Value {
  private final int price;

  public PricePerShare(int price) {
    this.price = price;
  }

  public int value() {
    return price;
  }
}
