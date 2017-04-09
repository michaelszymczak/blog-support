package com.michaelszymczak.diamond.implementation;

import com.michaelszymczak.diamond.api.Diamond;
import com.michaelszymczak.diamond.api.Letter;

import java.util.List;
import java.util.stream.Collectors;

public class AllLettersContainingDiamond implements Diamond {

  private Letter letter;

  public static AllLettersContainingDiamond of(Letter letter) {
    return new AllLettersContainingDiamond(letter);
  }

  private AllLettersContainingDiamond(Letter letter) {
    this.letter = letter;
  }

  @Override
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
