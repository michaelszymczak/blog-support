package com.michaelszymczak.foo.episode01

import spock.lang.Specification

class PortfolioShould extends Specification {

  def "have initially no shares or funds"() {
    given:
    def portfolio = Portfolio.emptyWithoutFunds()

    expect:
    ! portfolio.hasFunds()
  }

  def "accept funds"() {
    given:
    def portfolio = Portfolio.emptyWithoutFunds()

    when:
    def portfolioWithFunds = portfolio.afterAdding(someFunds())

    then:
    ! portfolio.hasFunds()
    portfolioWithFunds.hasFunds()
  }

  private static final Funds someFunds() {
    new Funds()
  }
}
