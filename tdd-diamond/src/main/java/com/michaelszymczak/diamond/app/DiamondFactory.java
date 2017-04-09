package com.michaelszymczak.diamond.app;

import com.michaelszymczak.diamond.api.Diamond;
import com.michaelszymczak.diamond.api.Letter;
import com.michaelszymczak.diamond.implementation.AllLettersContainingDiamond;

public class DiamondFactory {

  public Diamond createFor(Letter letter)
  {
    return AllLettersContainingDiamond.of(letter);
  }
}
