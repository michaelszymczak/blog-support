package com.michaelszymczak.blogsupport.coati

import org.joda.money.Money
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
  private void 'available funds should be USD 91863.30'() {
    expectedFundsAfterPurchase = Money.parse('USD 91863.30')
  }

  private void 'should have 10 shares of GOOG'() {
    expectedAssetsAfterPurchase = Assets.with([
            CompanyShares.of(new Ticker("GOOG"), 10)
    ])

    assert coati.portfolioOf(user) == Portfolio.with(expectedAssetsAfterPurchase, expectedFundsAfterPurchase)
  }

  private coati = new Coati()
  private user = new User()
  private Assets expectedAssetsAfterPurchase
  private Money expectedFundsAfterPurchase
}
