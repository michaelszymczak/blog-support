package com.michaelszymczak.foo.episode01

import spock.lang.Specification

class PortfolioShould extends Specification {

  def "have no shares or funds initially"() {
    given:
    def portfolio = emptyPortfolioOperatingOn(someMarket())

    expect:
    portfolio.noShares()
    portfolio.noFunds()
  }

//  def "receive funds for future investments"() {
//    given:
//    def portfolio = emptyPortfolioOperatingOn(someMarket())
//
//    when:
//    portfolio.after(addedFunds())
//
//    then:
//    ! portfolio.noFunds()
//    portfolio.availableFundsValue() == valueOf(addedFunds())
//  }

  private static PortfolioUnderTest emptyPortfolioOperatingOn(def market)
  {
    new PortfolioUnderTest()
  }

  private static someMarket() { null }

  private static class PortfolioUnderTest {

    PortfolioUnderTest() {
    }

    boolean noShares() { true }
    boolean noFunds() { true }
  }
}
