package com.michaelszymczak.diamond.implementation;

import com.google.common.collect.ImmutableSet;
import com.michaelszymczak.diamond.api.Letter;

import java.util.Set;

import static com.michaelszymczak.diamond.implementation.Coordinates.ofYX;

class Layout {

  private final Letter lastLetter;

  public static Layout forLastLetterBeing(Letter lastLetter) {
    return new Layout(lastLetter);
  }

  private Layout(Letter lastLetter) {
    this.lastLetter = lastLetter;
  }

  int yOfTop(Letter letter) {
    return letter.ordinal();
  }

  int yOfBottom(Letter letter) {
    return lastLetter.ordinal() + lastLetter.ordinal() - letter.ordinal();
  }

  int xOfLeft(Letter letter) {
    return lastLetter.ordinal() - letter.ordinal();
  }

  int xOfRight(Letter letter) {
    return lastLetter.ordinal() + letter.ordinal();
  }

  public Set<PositionedLetter> positioned(Letter letter) {
    return ImmutableSet.of(
            new PositionedLetter(ofYX(yOfTop(letter),xOfLeft(letter)), letter),
            new PositionedLetter(ofYX(yOfTop(letter),xOfRight(letter)), letter),
            new PositionedLetter(ofYX(yOfBottom(letter),xOfLeft(letter)), letter),
            new PositionedLetter(ofYX(yOfBottom(letter),xOfRight(letter)), letter)
    );
  }
}
