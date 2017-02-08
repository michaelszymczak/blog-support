package com.michaelszymczak.foo.episode01

import spock.lang.Specification

class PortfolioShould extends Specification {

  def "have initially no shares or funds"() {
    given:
    def portfolio = Portfolio.emptyWithoutFunds()

    expect:
    !portfolio.hasFunds()
  }

  def "accept funds"() {
    given:
    def portfolio = Portfolio.emptyWithoutFunds()

    when:
    def portfolioWithFunds = portfolio.afterAdding(someFunds())

    then:
    !portfolio.hasFunds()
    portfolioWithFunds.hasFunds()
  }

  def "accept even more funds"() {
    given:
    def portfolio = Portfolio.emptyWithoutFunds()
            .afterAdding(Funds.ofValue(firstAddedFundsValue))
            .afterAdding(Funds.ofValue(secondAddedFundsValue))

    expect:
    portfolio.availableFunds() == Funds.ofValue(expectedFundsValue)

    where:
    firstAddedFundsValue | secondAddedFundsValue | expectedFundsValue
    100                  | 50                    | 150
    1                    | 1                     | 2
  }

  def "buy a share"() {
    given:
    def portfolio = Portfolio
            .investingOn(StockMarket.trading([Company.withTicker("VOD").andPricePerShare(pricePerShare)] as Set))
            .afterAdding(Funds.ofValue(initialFunds))

    when:
    def portfolioWithSOmeStocks = portfolio.afterBuying("VOD")

    then:
    portfolioWithSOmeStocks.availableFunds() == Funds.ofValue(expectedAvailableFundsAfterTransaction)

    where:
    initialFunds | pricePerShare | expectedAvailableFundsAfterTransaction
    115          | 15            | 100
//    20           | 1             | 19
  }


  private static final Funds someFunds() {
    Funds.ofValue(100)
  }
}
