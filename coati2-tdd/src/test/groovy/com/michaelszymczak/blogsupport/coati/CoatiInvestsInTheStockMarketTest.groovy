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

  private void 'stock market listing GOOG sold USD 813.67 per share'() {
    stockMarket = StockMarket.listing([
            ListedCompany.withPricePerShare(new Ticker("GOOG"), usd("813.67"))
    ])
  }

  private void 'available funds of USD 100000'() {
    availableFundsBeforeTransaction = usd("100000")
  }

  private void 'no shares before transaction'() {
    assetsBeforeTransaction = noAssets()
  }

  private void 'bought 10 shares of GOOG'() {
    coati.addPortfolioFor(user, Portfolio.with(assetsBeforeTransaction, availableFundsBeforeTransaction))
    coati.buyFor(user, CompanyShares.of(new Ticker("GOOG"), 10))
  }

  private void 'available funds should be USD 91863.30'() {
    expectedFundsAfterTransaction = usd("91863.30")
  }

  private void 'should have 10 shares of GOOG'() {
    expectedAssetsAfterTransaction = Assets.with([
            CompanyShares.of(new Ticker("GOOG"), 10)
    ])

    assert coati.portfolioOf(user) == Portfolio.with(expectedAssetsAfterTransaction, expectedFundsAfterTransaction)
  }

  private User user = new User()

  private Coati coati = new Coati()
  private StockMarket stockMarket
  private Money availableFundsBeforeTransaction
  private Assets assetsBeforeTransaction
  private Assets expectedAssetsAfterTransaction
  private Money expectedFundsAfterTransaction

  private static Money usd(String amount)
  {
    Money.parse("USD $amount")
  }

  private static Assets noAssets() {
    Assets.with([])
  }
}
