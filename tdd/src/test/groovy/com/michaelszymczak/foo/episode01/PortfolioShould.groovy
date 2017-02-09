package com.michaelszymczak.foo.episode01

import spock.lang.Specification
import spock.lang.Unroll

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

  @Unroll
  def "buy shares of one company - given #initialFunds initial funds and #pricePerShare price per share, after buying #sharesBought shares should have #expectedAvailableFundsAfterTransaction funds after the transaction"() {
    given:
    def portfolio = Portfolio
            .investingOn(StockMarket.trading([Share.identifiedBy(someCompanyTicker()).andPricePerShare(pricePerShare)] as Set))
            .afterAdding(Funds.ofValue(initialFunds))

    when:
    def portfolioWithSomeStocks = portfolio.after(new BoughtShares([new CompanyShares(someCompanyTicker(), quantity)]))

    then:
    portfolioWithSomeStocks.availableFunds() == Funds.ofValue(expectedAvailableFundsAfterTransaction)
    portfolioWithSomeStocks.shares() == [new CompanyShares(someCompanyTicker(), quantity)]

    where:
    initialFunds | pricePerShare | quantity | expectedAvailableFundsAfterTransaction
    115          | 15            | 1        | 100
    20           | 1             | 1        | 19
    115          | 15            | 5        | 40
    20           | 1             | 10       | 10
  }

  def "should buy shares of more than one company at a time"() {
    given:
    def portfolio = Portfolio
            .investingOn(StockMarket.trading(
            [
                    Share.identifiedBy(Share.ticker("FOO")).andPricePerShare(5),
                    Share.identifiedBy(Share.ticker("BAR")).andPricePerShare(1),
                    Share.identifiedBy(Share.ticker("BAZ")).andPricePerShare(7),
            ] as Set))
            .afterAdding(Funds.ofValue(100))
    def sharesToBuy = new BoughtShares([
            new CompanyShares(Share.ticker("BAZ"), 3),
            new CompanyShares(Share.ticker("FOO"), 5)
    ])


    when:
    def portfolioWithSomeStocks = portfolio.after(sharesToBuy)

    then:
    portfolioWithSomeStocks.availableFunds() == Funds.ofValue(54)
    portfolioWithSomeStocks.shares() == sharesToBuy.shares
  }

  def "keep existing shares while purchasing new"() {
    given:
    def portfolio = Portfolio
            .investingOn(StockMarket.trading(
            [
                    Share.identifiedBy(Share.ticker("FOO")).andPricePerShare(1),
                    Share.identifiedBy(Share.ticker("BAR")).andPricePerShare(2)
            ] as Set))
            .afterAdding(Funds.ofValue(101))
            .after(new BoughtShares([new CompanyShares(Share.ticker("FOO"), 1)]))
    when:
    def portfolioWithSomeMoreStocks = portfolio.after(new BoughtShares([new CompanyShares(Share.ticker("BAR"), 3)]))

    then:
    portfolioWithSomeMoreStocks.availableFunds() == Funds.ofValue(94)
    portfolioWithSomeMoreStocks.shares() == [
            new CompanyShares(Share.ticker("FOO"), 1),
            new CompanyShares(Share.ticker("BAR"), 3)
    ]
  }

  private static Share.Ticker someCompanyTicker() {
    Share.ticker("VOD")
  }

  private static final Funds someFunds() {
    Funds.ofValue(100)
  }

  private static final StockMarket someStockMarket() {
    return new StockMarket([] as Set)
  }
}
