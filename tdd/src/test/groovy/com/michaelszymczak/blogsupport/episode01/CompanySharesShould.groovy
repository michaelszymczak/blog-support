package com.michaelszymczak.blogsupport.episode01

import spock.lang.Specification

class CompanySharesShould extends Specification {
  def "calculate how much they are worth based on stock market"() {
    given:
    def stockMarket = StockMarket.trading([
            Share.identifiedBy(Share.ticker("FOO")).andPricePerShare(10),
            Share.identifiedBy(Share.ticker("BAR")).andPricePerShare(20),
            Share.identifiedBy(Share.ticker("BAZ")).andPricePerShare(30)
    ] as Set)

    expect:
    new CompanyShares(Share.ticker("FOO"), 5).worthOn(stockMarket) == 50
    new CompanyShares(Share.ticker("BAZ"), 100).worthOn(stockMarket) == 3000
  }
}
