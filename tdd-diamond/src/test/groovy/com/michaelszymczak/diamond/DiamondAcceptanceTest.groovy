package com.michaelszymczak.diamond

import spock.lang.Specification

class DiamondAcceptanceTest extends Specification {

  def "contains one letter if it is the first letter"() {
    expect:
    Diamond.of('A' as char).rendered() == "A"
  }
}
