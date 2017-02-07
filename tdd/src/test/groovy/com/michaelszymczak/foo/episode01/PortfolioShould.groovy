package com.michaelszymczak.foo.episode01

import spock.lang.Specification

class PortfolioShould extends Specification {

  def "have initially no shares or funds"() {
    given:
    def portfolio = new Portfolio()

    expect:
    portfolio.noShares()
    portfolio.noFunds()
  }

  def "accept funds"() {
    given:
    def portfolio = new Portfolio()

    when:
    def portfolioWithFunds = portfolio.afterAdding(someFunds())

    then:
    portfolio.noFunds()
    ! portfolioWithFunds.noFunds()
  }

  private static final Funds someFunds() {
    new Funds()
  }
}
