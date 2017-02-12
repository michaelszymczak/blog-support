package com.michaelszymczak.blogsupport.coati

import org.joda.money.Money
import spock.lang.Specification

class PortfolioShould extends Specification {

  def "deduct the price of the bought share from available funds"() {
    given:
    Portfolio portfolio = Portfolio
            .tradingOn(StockMarket.listing([new ListedCompany(ticker, pricePerShare)]))
            .with(initialFunds, noShares())

    when:
    def portfolioAfterBuying = portfolio.afterBuying([new CompanyShares(ticker, howManyBought)])


    then:
    portfolio.funds() == initialFunds
    portfolio.shares() == noShares()
    portfolioAfterBuying.funds() == expectedFundsAfterThePurchase
    portfolioAfterBuying.shares() == [new CompanyShares(ticker, howManyBought)]

    where:
    ticker | pricePerShare | howManyBought | initialFunds | expectedFundsAfterThePurchase
    "FOO"  | usd(10)       | 1             | usd(60)      | usd(50)
    "BAR"  | usd(1)        | 1             | usd(100)     | usd(99)
    "BAZ"  | usd(3)        | 7             | usd(121)     | usd(100)
  }

  def "deduct the cost of all bought shares"() {
    given:
    def stockMarket = StockMarket.listing([
            new ListedCompany("FOO", usd(1)),
            new ListedCompany("BAR", usd(2)),
            new ListedCompany("BAZ", usd(3))
    ])

    def initialFunds = usd(100)

    def sharesToBuy = [
            new CompanyShares("FOO", 7),
            new CompanyShares("BAZ", 3),
    ]

    when:
    Portfolio portfolio = Portfolio
            .tradingOn(stockMarket)
            .with(initialFunds, noShares())
            .afterBuying(sharesToBuy)

    then:
    portfolio.funds() == usd(84)
    portfolio.shares() == sharesToBuy
  }

  private static Money usd(def howMany) {
    Money.parse("USD $howMany")
  }

  private static List<CompanyShares> noShares() {
    []
  }
}
