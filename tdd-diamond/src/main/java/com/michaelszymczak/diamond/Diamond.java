package com.michaelszymczak.diamond;

public class Diamond {
  public static Diamond of(char letter) {
    return new Diamond();
  }

  public String rendered() {
    return "A";
  }
}
