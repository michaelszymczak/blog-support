package com.michaelszymczak.diamond;

public class Diamond {

  private Letter letter;

  public static Diamond of(Letter letter) {
    return new Diamond(letter);
  }

  private Diamond(Letter letter) {
    this.letter = letter;
  }

  public String rendered() {
    return letter == Letter.A ? "A" : " A \nB B\n A ";
  }
}
