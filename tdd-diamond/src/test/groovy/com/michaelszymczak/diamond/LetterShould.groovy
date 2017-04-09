package com.michaelszymczak.diamond

import spock.lang.Specification

class LetterShould extends Specification {

  def "have position in the alphabet as its ordinal number"() {
    expect:
    Letter.A.ordinal() == 0
    Letter.B.ordinal() == 1
    Letter.C.ordinal() == 2
    Letter.D.ordinal() == 3
  }
}
