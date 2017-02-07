package com.michaelszymczak.foo.episode01;

public class Funds {

  private final int value;

  @Deprecated
  public Funds()
  {
    this(0);
  }

  private Funds(int value)
  {
    this.value = value;
  }

  public static Funds ofValue(int value) {
    return new Funds(value);
  }


  public boolean available() {
    return value != 0;
  }
}
