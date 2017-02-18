package com.michaelszymczak.blogsupport.coati

import spock.lang.Specification

class CoatiInvestsInTheStockMarketTest extends Specification {
  def "buy some shares having enough funds"() {
    given:
    'stock market listing GOOG sold USD 813.67 per share'()
    'available funds of USD 100000'()
    'no shares before transaction'()

    when:
    'bought 10 shares of GOOG'()

    then:
    'available funds should be USD 91863.30'()
    'should have 10 shares of GOOG'()
  }

  private static void 'stock market listing GOOG sold USD 813.67 per share'() {
    // TODO
  }
  private static void 'available funds of USD 100000'() {
    // TODO
  }
  private static void 'no shares before transaction'() {
    // TODO
  }
  private static void 'bought 10 shares of GOOG'() {
    // TODO
  }
  private static void 'available funds should be USD 91863.30'() {
    // TODO
  }

  private void 'should have 10 shares of GOOG'() {
    assert coati.portfolioOf(user) == Portfolio.with(Assets.with([
            CompanyShares.of(new Ticker("GOOG"), 10)
    ]))
  }

  private coati = new Coati()
  private user = new User()
}
