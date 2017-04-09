package com.michaelszymczak.diamond;

import static com.michaelszymczak.diamond.Coordinates.ofYX;
import static com.michaelszymczak.diamond.Letter.*;

public class Diamond {

  private Letter letter;

  public static Diamond of(Letter letter) {
    return new Diamond(letter);
  }

  private Diamond(Letter letter) {
    this.letter = letter;
  }

  public String rendered() {
    if (letter == A)
    {
      return new Board(new PositionedLetter(ofYX(0,0), A)).toString();
    }
    if (letter == B)
    {
      return new Board(
              new PositionedLetter(ofYX(0,1), A),
              new PositionedLetter(ofYX(1,0), B), new PositionedLetter(ofYX(1,2), B),
              new PositionedLetter(ofYX(2,1), A)
      ).toString();
    }

    return new Board(
            new PositionedLetter(ofYX(0,2), A),
            new PositionedLetter(ofYX(1,1), B), new PositionedLetter(ofYX(1,3), B),
            new PositionedLetter(ofYX(2,0), C), new PositionedLetter(ofYX(2,4), C),
            new PositionedLetter(ofYX(3,1), B), new PositionedLetter(ofYX(3,3), B),
            new PositionedLetter(ofYX(4,2), A)
    ).toString();

  }
}
