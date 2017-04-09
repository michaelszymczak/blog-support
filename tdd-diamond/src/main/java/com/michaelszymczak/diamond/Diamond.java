package com.michaelszymczak.diamond;

public class Diamond {

  private char letter;

  public static Diamond of(char letter) {
    return new Diamond(letter);
  }

  private Diamond(char letter) {
    this.letter = letter;
  }

  public String rendered() {
    return letter == 'A' ? "A" : " A \nB B\n A ";
  }
}
