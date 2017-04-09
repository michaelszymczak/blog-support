package com.michaelszymczak.diamond

import spock.lang.Specification

class DiamondAcceptanceTest extends Specification {

  def "contains one letter if it is the first letter"() {
    expect:
    Diamond.of('A' as char).rendered() == "A"
  }

  def "creates diamond shape if more than one letter"() {
    expect:
    Diamond.of('B' as char).rendered() == " A " + "\n" +
                                          "B B" + "\n" +
                                          " A "

  }
}
