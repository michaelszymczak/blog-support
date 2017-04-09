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
    final Layout layout = new Layout();
    if (letter == A)
    {
      return new Board(new PositionedLetter(ofYX(layout.yOfTopLeft(A),0), A)).toString();
    }
    if (letter == B)
    {
      return new Board(
              new PositionedLetter(ofYX(layout.yOfTopLeft(A),1), A),
              new PositionedLetter(ofYX(layout.yOfTopLeft(B),0), B), new PositionedLetter(ofYX(layout.yOfTopRight(B),2), B),
              new PositionedLetter(ofYX(2,1), A)
      ).toString();
    }

    return new Board(
            new PositionedLetter(ofYX(layout.yOfTopLeft(A),2), A),
            new PositionedLetter(ofYX(layout.yOfTopLeft(B),1), B), new PositionedLetter(ofYX(1,3), B),
            new PositionedLetter(ofYX(layout.yOfTopLeft(C),0), C), new PositionedLetter(ofYX(layout.yOfTopRight(C),4), C),
            new PositionedLetter(ofYX(3,1), B), new PositionedLetter(ofYX(3,3), B),
            new PositionedLetter(ofYX(4,2), A)
    ).toString();

  }
}
