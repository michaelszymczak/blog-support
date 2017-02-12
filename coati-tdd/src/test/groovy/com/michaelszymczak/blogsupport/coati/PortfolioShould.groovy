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
    def portfolioAfterBuying = portfolio.afterBuying([new CompanyShares(ticker, 1)])


    then:
    portfolio.funds() == initialFunds
    portfolio.shares() == noShares()
    portfolioAfterBuying.funds() == expectedFundsAfterThePurchase
    portfolioAfterBuying.shares() == [new CompanyShares(ticker, 1)]

    where:
    ticker | pricePerShare | initialFunds | expectedFundsAfterThePurchase
    "FOO"  | usd(10)       | usd(60)      | usd(50)
//    "BAR"  | usd(1)        | usd(100)     | usd(99) // TODO
  }

  private static Money usd(def howMany) {
    Money.parse("USD $howMany")
  }

  private static List<CompanyShares> noShares() {
    []
  }
}
