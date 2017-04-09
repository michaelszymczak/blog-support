package com.michaelszymczak.diamond

import spock.lang.Specification

class DiamondAcceptanceTest extends Specification {

  def "contains one letter if it is the first letter"() {
    expect:
    Diamond.of(Letter.A).rendered() == "A"
  }

  def "creates diamond shape if more than one letter"() {
    expect:
    Diamond.of(Letter.B).rendered() == "" +
            " A " + "\n" +
            "B B" + "\n" +
            " A "
  }
}
