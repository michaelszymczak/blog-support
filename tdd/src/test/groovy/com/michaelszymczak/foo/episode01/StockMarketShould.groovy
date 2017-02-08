package com.michaelszymczak.foo.episode01

import spock.lang.Specification

class StockMarketShould extends Specification {
  def "tell the price per share"() {
    given:
    StockMarket stockMarket = StockMarket.trading([
            Share.withTicker("FOO").andPricePerShare(20)] as Set)

    expect:
    stockMarket.priceOf(Share.ticker("FOO")) == 20
  }
}
