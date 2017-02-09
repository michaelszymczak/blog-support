package com.michaelszymczak.foo.episode01

import spock.lang.Specification

class PortfolioShould extends Specification {

  def "have initially no shares or funds"() {
    given:
    def portfolio = Portfolio.investingOn(someStockMarket())

    expect:
    !portfolio.hasFunds()
    portfolio.shares().isEmpty()
  }

  def "accept funds"() {
    given:
    def portfolio = Portfolio.investingOn(someStockMarket())

    when:
    def portfolioWithFunds = portfolio.afterAdding(someFunds())

    then:
    !portfolio.hasFunds()
    portfolioWithFunds.hasFunds()
  }

  def "accept even more funds"() {
    given:
    def portfolio = Portfolio.investingOn(someStockMarket())
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
            .investingOn(StockMarket.trading([Share.withTicker("VOD").andPricePerShare(pricePerShare)] as Set))
            .afterAdding(Funds.ofValue(initialFunds))

    when:
    def portfolioWithSomeStocks = portfolio.afterBuying(Share.ticker("VOD"))

    then:
    portfolioWithSomeStocks.availableFunds() == Funds.ofValue(expectedAvailableFundsAfterTransaction)
    portfolioWithSomeStocks.shares() == [new CompanyShares(Share.ticker("VOD"), 1)]

    where:
    initialFunds | pricePerShare | expectedAvailableFundsAfterTransaction
    115          | 15            | 100
    20           | 1             | 19
  }


  private static final Funds someFunds() {
    Funds.ofValue(100)
  }

  private static final StockMarket someStockMarket()
  {
    return new StockMarket([] as Set)
  }
}
