package com.michaelszymczak.blogsupport.coati

import org.joda.money.Money
import spock.lang.Specification

class CoatiShouldInvestInTheStockMarketTest extends Specification {

  private Coati coati
  private StockMarket stockMarket
  private Money initialFunds
  private List<CompanyShares> initialShares

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
    stockMarket = new StockMarket([new ListedCompany("GOOG", Money.parse('USD 813.67'))])
  }

  private void 'available funds USD 100000'() {
    initialFunds = Money.parse('USD 100000')
  }

  private void 'no shares'() {
    initialShares = []
  }

  private void 'bought 10 of GOOG'() {
    coati = new Coati(stockMarket, initialFunds, initialShares)
    coati = coati.bought([CompanyShares.of("GOOGL", 10)])
  }

  private void 'available funds should be USD 91863.30'() {
    assert coati.funds() == Money.parse('USD 91863.30')
  }

  private void 'should have 10 shares of GOOG'() {
    assert coati.portfolio() == Portfolio.with([CompanyShares.of("GOOGL", 10)])
  }

}
