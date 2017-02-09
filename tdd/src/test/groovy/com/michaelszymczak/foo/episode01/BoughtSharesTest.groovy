package com.michaelszymczak.foo.episode01

import spock.lang.Specification

class BoughtSharesTest extends Specification {
  def "should calculate its total price on stock market"() {
    given:
    def stockMarket = StockMarket.trading([
            Share.identifiedBy(Share.ticker("FOO")).andPricePerShare(5),
            Share.identifiedBy(Share.ticker("BAR")).andPricePerShare(9)
    ] as Set)
    def boughtShares = new BoughtShares([
            new CompanyShares(Share.ticker("FOO"), 1),
            new CompanyShares(Share.ticker("BAR"), 3),
    ] as Set)

    expect:
    boughtShares.totalPriceOn(stockMarket) == 32
  }

  def "should group shares of the same company together with previously bought ones"() {
    given:
    def initiallyBoughtShares = new BoughtShares([
            new CompanyShares(Share.ticker("FOO"), 1),
            new CompanyShares(Share.ticker("BAR"), 2),
            new CompanyShares(Share.ticker("BAZ"), 3),
    ] as Set)
    def laterBoughtShares = new BoughtShares([
            new CompanyShares(Share.ticker("FOO"), 4),
            new CompanyShares(Share.ticker("BAR"), 5),
            new CompanyShares(Share.ticker("QUX"), 6),
    ] as Set)

    expect:
    initiallyBoughtShares.withMore(laterBoughtShares) == new BoughtShares([
            new CompanyShares(Share.ticker("FOO"), 5),
            new CompanyShares(Share.ticker("BAR"), 7),
            new CompanyShares(Share.ticker("BAZ"), 3),
            new CompanyShares(Share.ticker("QUX"), 6)
    ] as Set)
  }
}
