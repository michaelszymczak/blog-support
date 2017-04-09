package com.michaelszymczak.diamond.implementation

import spock.lang.Specification

import static com.michaelszymczak.diamond.api.Letter.*

class LetterShould extends Specification {

  def "have position in the alphabet as its ordinal number"() {
    expect:
    A.ordinal() == 0
    B.ordinal() == 1
    C.ordinal() == 2
    D.ordinal() == 3
  }

  def "return all letters up to the specified one"() {
    expect:
    A.inclusiveSequence() == [A]
    B.inclusiveSequence() == [A,B]
    D.inclusiveSequence() == [A,B,C,D]
  }
}
