package com.michaelszymczak.diamond;

public class Layout {

  private final Letter lastLetter;

  public static Layout forLastLetterBeing(Letter lastLetter) {
    return new Layout(lastLetter);
  }

  private Layout(Letter lastLetter) {
    this.lastLetter = lastLetter;
  }

  public int yOfTop(Letter letter) {
    return letter.ordinal();
  }

  public int yOfBottom(Letter letter) {
    return lastLetter.ordinal() * 2 - letter.ordinal();
  }

  public int xOfLeft(Letter letter) {
    return lastLetter.ordinal() - letter.ordinal();
  }

}
