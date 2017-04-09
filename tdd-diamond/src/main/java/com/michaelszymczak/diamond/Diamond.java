package com.michaelszymczak.diamond;

import com.google.common.collect.ImmutableSet;

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
      return new Board(Layout.forLastLetterBeing(A).positioned(A)).toString();
    }
    if (letter == B)
    {
      Layout layout = Layout.forLastLetterBeing(B);
      return new Board(new ImmutableSet.Builder<PositionedLetter>()
              .addAll(layout.positioned(A))
              .addAll(layout.positioned(B))
              .build()
      ).toString();
    }

    Layout layout = Layout.forLastLetterBeing(C);
    return new Board(new ImmutableSet.Builder<PositionedLetter>()
            .addAll(layout.positioned(A))
            .addAll(layout.positioned(B))
            .addAll(layout.positioned(C))
            .build()
    ).toString();

  }
}
