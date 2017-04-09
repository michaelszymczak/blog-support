package com.michaelszymczak.diamond

import spock.lang.Specification

class LayoutShould extends Specification {
  def "let the top letter to be in ordinal number distance from the top"() {
    given:
    def layout = new Layout()

    expect:
    layout.yOfTopLeft(Letter.A) == 0
    layout.yOfTopLeft(Letter.C) == 2
    layout.yOfTopRight(Letter.A) == 0
    layout.yOfTopRight(Letter.C) == 2
  }
}
