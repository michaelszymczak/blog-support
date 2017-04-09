package com.michaelszymczak.diamond

import spock.lang.Specification

import static com.michaelszymczak.diamond.Coordinates.ofYX
import static com.michaelszymczak.diamond.Layout.forLastLetterBeing
import static com.michaelszymczak.diamond.Letter.A
import static com.michaelszymczak.diamond.Letter.B
import static com.michaelszymczak.diamond.Letter.C
import static com.michaelszymczak.diamond.Letter.D

class LayoutShould extends Specification {

  def "let the top letter to be in ordinal number distance from the top"() {
    given:
    def layout = forLastLetterBeing(D)

    expect:
    layout.yOfTop(A) == 0
    layout.yOfTop(B) == 1
    layout.yOfTop(C) == 2
    layout.yOfTop(D) == 3
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

  def "let the right letter to be closer if their ordinal number is higher"() {
    given:
    def layout = forLastLetterBeing(D)

    expect:
    layout.xOfRight(A) == 3
    layout.xOfRight(B) == 4
    layout.xOfRight(C) == 5
    layout.xOfRight(D) == 6
  }

  def "generate coordinates for each letter based on last letter"() {
    expect:
    forLastLetterBeing(A).positioned(A) == [new PositionedLetter(ofYX(0,0), A)] as Set
    forLastLetterBeing(B).positioned(A) == [
            new PositionedLetter(ofYX(0,1), A),
            new PositionedLetter(ofYX(2,1), A)
    ] as Set
    forLastLetterBeing(B).positioned(B) == [
            new PositionedLetter(ofYX(1,0), B),
            new PositionedLetter(ofYX(1,2), B)
    ] as Set
    forLastLetterBeing(C).positioned(B) == [
            new PositionedLetter(ofYX(1,1), B), new PositionedLetter(ofYX(1,3), B),
            new PositionedLetter(ofYX(3,1), B), new PositionedLetter(ofYX(3,3), B),
    ] as Set
  }
}
