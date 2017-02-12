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
    company | pricePerShare
    "GOOG"  | usd(100)
    "FOO"   | usd(5)
  }

  def "tell the price of company shares"() {
    given:
    def stockMarket = StockMarket.listing([
            new ListedCompany("GOOG", usd(4)),
            new ListedCompany("TWTR", usd(3)),
    ])

    expect:
    stockMarket.priceOf(shares) == expectedPrice

    where:
    shares                        | expectedPrice
    new CompanyShares("GOOG", 10) | usd(40)
    new CompanyShares("TWTR", 20) | usd(60)
  }


  def "tell the total price of shares of many companies"() {
    given:
    def stockMarket = StockMarket.listing([
            new ListedCompany("GOOG", usd(4)),
            new ListedCompany("TWTR", usd(3)),
    ])
    def sharesToBuy = [
            new CompanyShares("GOOG", 10),
            new CompanyShares("TWTR", 20)
    ]

    expect:
    stockMarket.priceOf(sharesToBuy) == usd(100)
  }

  private static Money usd(float amount) {
    Money.parse("USD " + String.valueOf(amount))
  }
}
