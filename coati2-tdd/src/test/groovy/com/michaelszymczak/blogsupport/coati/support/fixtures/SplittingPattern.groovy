package com.michaelszymczak.blogsupport.coati.support.fixtures

import com.google.common.base.Preconditions

@FunctionalInterface
interface SplittingPattern {

  String pattern()

  class And implements SplittingPattern {

    private final String input

    And(String input) {
      this.input = Preconditions.checkNotNull(input)
    }

    @Override
    String pattern()
    {
      "(.+)" + ((0..<input.count("and")).collect { " and (.+)" }.join(""))
    }
  }
}
