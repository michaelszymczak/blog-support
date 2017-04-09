package com.michaelszymczak.diamond

import spock.lang.Specification

import static com.michaelszymczak.diamond.Layout.forLastLetterBeing
import static com.michaelszymczak.diamond.Letter.A
import static com.michaelszymczak.diamond.Letter.B
import static com.michaelszymczak.diamond.Letter.C
import static com.michaelszymczak.diamond.Letter.D

class LayoutShould extends Specification {

  def "let the top letter to be in ordinal number distance from the top"() {
    given:
    def layout = layout()

    expect:
    layout.yOfTop(A) == 0
    layout.yOfTop(C) == 2
  }

  def "let the bottom letter to be in ordinal number distance from the bottom which is twice the ordinal number of the max letter"() {
    given:
    def layout = forLastLetterBeing(D)

    expect:
    layout.yOfBottom(D) == 3
    layout.yOfBottom(C) == 4
    layout.yOfBottom(B) == 5
    layout.yOfBottom(A) == 6
  }

  def "let the left letter to be in reverse ordinal number distance from the left"() {
    given:
    def layout = forLastLetterBeing(D)

    expect:
    layout.xOfLeft(D) == 0
    layout.xOfLeft(C) == 1
    layout.xOfLeft(B) == 2
    layout.xOfLeft(A) == 3
  }

  private static Layout layout() {
    forLastLetterBeing(C)
  }
}
