package com.michaelszymczak.diamond

import spock.lang.Specification

class LayoutShould extends Specification {
  def "let the top letter to be in ordinal number distance from the top"() {
    given:
    def layout = layout()

    expect:
    layout.yOfTop(Letter.A) == 0
    layout.yOfTop(Letter.C) == 2
  }

  def "let the bottom letter to be in ordinal number distance from the bottom which is twice the ordinal number of the max letter"() {
    given:
    def layout = Layout.forLastLetterBeing(Letter.D)

    expect:
    layout.yOfBottom(Letter.D) == 3
    layout.yOfBottom(Letter.C) == 4
    layout.yOfBottom(Letter.B) == 5
    layout.yOfBottom(Letter.A) == 6
  }

  private static Layout layout() {
    Layout.forLastLetterBeing(Letter.C)
  }
}
