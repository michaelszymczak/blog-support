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
      Layout layout = Layout.forLastLetterBeing(A);
      return new Board(new PositionedLetter(ofYX(layout.yOfTop(A),layout.xOfLeft(A)), A)).toString();
    }
    if (letter == B)
    {
      Layout layout = Layout.forLastLetterBeing(B);
      return new Board(
              new PositionedLetter(ofYX(layout.yOfTop(A),layout.xOfLeft(A)), A),
              new PositionedLetter(ofYX(layout.yOfTop(B),layout.xOfLeft(B)), B), new PositionedLetter(ofYX(layout.yOfTop(B),2), B),
              new PositionedLetter(ofYX(layout.yOfBottom(A),1), A)
      ).toString();
    }

    Layout layout = Layout.forLastLetterBeing(C);
    return new Board(
            new PositionedLetter(ofYX(layout.yOfTop(A),layout.xOfLeft(A)), A),
            new PositionedLetter(ofYX(layout.yOfTop(B),layout.xOfLeft(B)), B), new PositionedLetter(ofYX(layout.yOfTop(B),3), B),
            new PositionedLetter(ofYX(layout.yOfTop(C),layout.xOfLeft(C)), C), new PositionedLetter(ofYX(layout.yOfTop(C),4), C),
            new PositionedLetter(ofYX(layout.yOfBottom(B),layout.xOfLeft(B)), B), new PositionedLetter(ofYX(layout.yOfBottom(B),3), B),
            new PositionedLetter(ofYX(layout.yOfBottom(A),layout.xOfLeft(A)), A)
    ).toString();

  }
}
