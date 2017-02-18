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

  private static void 'stock market listing GOOG sold USD 813.67 per share'() {}
  private static void 'available funds of USD 100000'() {}
  private static void 'no shares before transaction'() {}
  private static void 'bought 10 shares of GOOG'() {}
  private static void 'available funds should be USD 91863.30'() {}
  private static void 'should have 10 shares of GOOG'() {}
}
