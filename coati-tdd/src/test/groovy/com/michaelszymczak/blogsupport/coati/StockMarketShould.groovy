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
    "GOOG"  | Money.parse("USD 100")
    "FOO"   | Money.parse("USD 5")
  }
}
