package com.michaelszymczak.blogsupport.coati

import org.joda.money.Money
import spock.lang.Specification

class StockMarketShould extends Specification {
  def "tell the price per company share"() {
    given:
    def stockMarket = StockMarket.listing([new ListedCompany(company, pricePerShare)])

    expect:
    stockMarket.priceOf(company) == pricePerShare

    where:
    company        | pricePerShare
    ticker("GOOG") | usd(100)
    ticker("FOO")  | usd(5)
  }

  def "tell the price of company shares"() {
    given:
    def stockMarket = StockMarket.listing([
            new ListedCompany(ticker("GOOG"), usd(4)),
            new ListedCompany(ticker("TWTR"), usd(3)),
    ])

    expect:
    stockMarket.priceOf(shares) == expectedPrice

    where:
    shares                                | expectedPrice
    CompanyShares.of(ticker("GOOG"), 10) | usd(40)
    CompanyShares.of(ticker("TWTR"), 20) | usd(60)
  }


  def "tell the total price of shares of many companies"() {
    given:
    def stockMarket = StockMarket.listing([
            new ListedCompany(ticker("GOOG"), usd(4)),
            new ListedCompany(ticker("TWTR"), usd(3)),
    ])
    def sharesToBuy = [
            CompanyShares.of(ticker("GOOG"), 10),
            CompanyShares.of(ticker("TWTR"), 20)
    ]

    expect:
    stockMarket.priceOf(sharesToBuy) == usd(100)
  }

  private static Money usd(float amount) {
    Money.parse("USD " + String.valueOf(amount))
  }

  private static Ticker ticker(String code) {
    new Ticker(code)
  }
}
