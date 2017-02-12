package com.michaelszymczak.blogsupport.coati

import org.joda.money.Money
import spock.lang.Specification

class PortfolioShould extends Specification {

  def "deduct the price of the bought share from available funds"() {
    given:
    Portfolio portfolio = Portfolio
            .tradingOn(StockMarket.listing([new ListedCompany("FOO", Money.parse("USD 10"))]))
            .with(Money.parse("USD 60"), noShares())

    when:
    def portfolioAfterBuying = portfolio.afterBuying([new CompanyShares("FOO", 1)])

    then:
    portfolio.funds() == Money.parse("USD 60")
    portfolio.shares() == noShares()
    portfolioAfterBuying.funds() == Money.parse("USD 50")
    portfolioAfterBuying.shares() == [new CompanyShares("FOO", 1)]
  }

  private static List<CompanyShares> noShares() {
    []
  }
}
