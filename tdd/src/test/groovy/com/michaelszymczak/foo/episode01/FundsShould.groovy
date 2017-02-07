package com.michaelszymczak.foo.episode01

import spock.lang.Specification

class FundsShould extends Specification {

  def "tell if they are worth anything"() {
    expect:
    Funds.ofValue(value as int).available() == shouldBeAvailable

    where:
    value             | shouldBeAvailable
    0                 | false
    1                 | true
    Integer.MAX_VALUE | true
  }
}
