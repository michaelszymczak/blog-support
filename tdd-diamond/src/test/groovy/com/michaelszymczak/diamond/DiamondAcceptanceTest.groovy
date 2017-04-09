package com.michaelszymczak.diamond

import spock.lang.Specification

class DiamondAcceptanceTest extends Specification {

  def "contains one letter if it is the first letter"() {
    expect:
    Diamond.of(Letter.A).rendered() == "A"
  }

  def "uses all letters up to the provided one"() {
    expect:
    Diamond.of(Letter.B).rendered() == "" +
            " A " + "\n" +
            "B B" + "\n" +
            " A "
  }

  def "creates diamond-like shape"() {
    expect:
    Diamond.of(Letter.C).rendered() == "" +
            "  A  " + "\n" +
            " B B " + "\n" +
            "C   C" + "\n" +
            " B B " + "\n" +
            "  A  "
  }


}
