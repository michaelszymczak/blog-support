package com.michaelszymczak.blogsupport.episode01

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

  def "return new instance with more funds added"() {
    given:
    def originalFunds = Funds.ofValue(50)

    when:
    def newFunds = originalFunds.withAdded(Funds.ofValue(addedValue))

    then:
    originalFunds == Funds.ofValue(50)
    newFunds == Funds.ofValue(expectedNewFundsValue)

    where:
    addedValue | expectedNewFundsValue
    0          | 50
    1          | 51
    100        | 150
  }

  def "return new instance with some funds subtracted"() {
    given:
    def originalFunds = Funds.ofValue(50)

    when:
    def newFunds = originalFunds.withSubtracted(Funds.ofValue(subtractedValue))

    then:
    originalFunds == Funds.ofValue(50)
    newFunds == Funds.ofValue(expectedNewFundsValue)

    where:
    subtractedValue | expectedNewFundsValue
    0               | 50
    1               | 49
    50              | 0
  }
}
