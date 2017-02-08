package com.michaelszymczak.foo.episode01

import spock.lang.Specification

class StockMarketShould extends Specification {
  def "tell the price per share"() {
    given:
    StockMarket stockMarket = StockMarket.trading([
            Share.withTicker("FOO").andPricePerShare(20),
            Share.withTicker("BAR").andPricePerShare(40)
    ] as Set)

    expect:
    stockMarket.priceOf(Share.ticker("FOO")) == new Share.PricePerShare(20)
    stockMarket.priceOf(Share.ticker("BAR")) == new Share.PricePerShare(40)
  }
}
