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

  // Enough funds to start buying shares

  def "buy some shares"() {
    given:
    def portfolio = Portfolio
            .investingOn(stockMarketTrading("VOD|15"))
            .afterAdding(Funds.ofValue(115))

    when:
    def portfolioWithSOmeStocks = portfolio.afterBuying("VOD")

    then:
    portfolioWithSOmeStocks.availableFunds() == Funds.ofValue(100)
  }

  private stockMarketTrading(String sharePrices) {
    null
  }

  private static final Funds someFunds() {
    Funds.ofValue(100)
  }
}
