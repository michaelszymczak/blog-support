package com.michaelszymczak.blogsupport.coati

import spock.lang.Specification

class CoatiShouldInvestInTheStockMarketTest extends Specification {

  private Coati coati

  def "buy some shares having enough funds"() {
    given:
    'stock market listing GOOG sold USD 813.67 per share'()
    'available funds USD 100000'()
    'no shares'()

    when:
    'bought 10 of GOOG'()

    then:
    'available funds should be USD 91863.30'()
    'should have 10 shares of GOOG'()
  }

  private void 'stock market listing GOOG sold USD 813.67 per share'() {
  }

  private void 'available funds USD 100000'() {
  }

  private void 'no shares'() {
    coati = new Coati()
  }

  private void 'bought 10 of GOOG'() {
  }

  private void 'available funds should be USD 91863.30'() {
  }

  private void 'should have 10 shares of GOOG'() {
    assert coati.portfolio() == Portfolio.with([CompanyShares.of("GOOGL", 10)])
  }

}
