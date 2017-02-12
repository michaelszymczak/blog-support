package com.michaelszymczak.blogsupport.coati

import org.joda.money.Money
import spock.lang.Specification

class PortfolioShould extends Specification {

  def "be comparable based on assets and stock market it invests on"() {
    given:
    final stockMarketA = StockMarket.listing([new ListedCompany(ticker("FOO"), usd(1))])
    final stockMarketB = StockMarket.listing([new ListedCompany(ticker("BAR"), usd(2))])
    final Money fundsA = usd(3)
    final Money fundsB = usd(4)
    final List<CompanyShares> sharesA = [CompanyShares.of(ticker("FOO"), 1)]
    final List<CompanyShares> sharesB = [CompanyShares.of(ticker("FOO"), 2)]
    final Portfolio portfolio = Portfolio.tradingOn(stockMarketA)

    expect:
    portfolio == Portfolio.tradingOn(stockMarketA)
    portfolio != Portfolio.tradingOn(stockMarketB)
    portfolio.with(fundsA, sharesA) == portfolio.with(fundsA, sharesA)
    portfolio.with(fundsA, sharesA) != portfolio.with(fundsA, sharesB)
    portfolio.with(fundsA, sharesA) != portfolio.with(fundsB, sharesA)
  }

  def "deduct the price of the bought share from available funds"() {
    given:
    final stockMarket = StockMarket.listing([new ListedCompany(ticker, pricePerShare)])
    final Portfolio portfolio = Portfolio.tradingOn(stockMarket).with(initialFunds, noShares())

    when:
    def portfolioAfterBuying = portfolio.afterBuying([CompanyShares.of(ticker, howManyBought)])

    then:
    portfolio == Portfolio.tradingOn(stockMarket).with(initialFunds, noShares())
    portfolioAfterBuying == Portfolio.tradingOn(stockMarket)
            .with(expectedFundsAfterThePurchase, [CompanyShares.of(ticker, howManyBought)])

    where:
    ticker        | pricePerShare | howManyBought | initialFunds | expectedFundsAfterThePurchase
    ticker("FOO") | usd(10)       | 1             | usd(60)      | usd(50)
    ticker("BAR") | usd(1)        | 1             | usd(100)     | usd(99)
    ticker("BAZ") | usd(3)        | 7             | usd(121)     | usd(100)
  }

  def "deduct the cost of all bought shares"() {
    given:
    def stockMarket = StockMarket.listing([
            new ListedCompany(ticker("FOO"), usd(1)),
            new ListedCompany(ticker("BAR"), usd(2)),
            new ListedCompany(ticker("BAZ"), usd(3))
    ])

    def initialFunds = usd(100)

    def sharesToBuy = [
            CompanyShares.of(ticker("FOO"), 7),
            CompanyShares.of(ticker("BAZ"), 3),
    ]

    when:
    Portfolio portfolio = Portfolio
            .tradingOn(stockMarket)
            .with(initialFunds, noShares())
            .afterBuying(sharesToBuy)

    then:
    portfolio == Portfolio
            .tradingOn(stockMarket)
            .with(usd(84), sharesToBuy)
  }

  private static Money usd(def howMany) {
    Money.parse("USD $howMany")
  }

  private static List<CompanyShares> noShares() {
    []
  }

  private static Ticker ticker(String code) {
    new Ticker(code)
  }
}
