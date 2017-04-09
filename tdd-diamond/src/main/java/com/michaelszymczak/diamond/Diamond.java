package com.michaelszymczak.diamond;

import static com.michaelszymczak.diamond.Coordinates.ofYX;
import static com.michaelszymczak.diamond.Letter.A;
import static com.michaelszymczak.diamond.Letter.B;

public class Diamond {

  private Letter letter;

  public static Diamond of(Letter letter) {
    return new Diamond(letter);
  }

  private Diamond(Letter letter) {
    this.letter = letter;
  }

  public String rendered() {
    return letter == A ? new Board(new PositionedLetter(ofYX(0,0), A)).toString()
            : new Board(
            new PositionedLetter(ofYX(0,1), A),
            new PositionedLetter(ofYX(1,0), B), new PositionedLetter(ofYX(1,2), B),
            new PositionedLetter(ofYX(2,1), A)
    ).toString();
  }
}
