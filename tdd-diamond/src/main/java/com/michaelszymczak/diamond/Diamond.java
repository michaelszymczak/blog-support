package com.michaelszymczak.diamond;

import java.util.List;
import java.util.stream.Collectors;

public class Diamond {

  private Letter letter;

  public static Diamond of(Letter letter) {
    return new Diamond(letter);
  }

  private Diamond(Letter letter) {
    this.letter = letter;
  }

  public String rendered() {
    return new Board(allPositionedLetters()).toString();
  }

  private List<PositionedLetter> allPositionedLetters() {
    final Layout layout = Layout.forLastLetterBeing(letter);

    return letter.inclusiveSequence().stream()
            .flatMap(l -> layout.positioned(l).stream())
            .collect(Collectors.toList());
  }
}
