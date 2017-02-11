package com.michaelszymczak.blogsupport.coati

import org.joda.money.Money
import spock.lang.Specification

import static com.michaelszymczak.blogsupport.coati.support.CompanySharesFixtures.companySharesBasedOn
import static com.michaelszymczak.blogsupport.coati.support.ListedCompanyFixtures.listedCompaniesBasedOn

class CoatiShouldInvestInTheStockMarketTest extends Specification {

  private Coati coati
  private StockMarket stockMarket
  private Money initialFunds
  private List<CompanyShares> initialShares

  def "buy some shares having enough funds"() {
    given:
    'stock market listing' 'GOOG sold USD 813.67 per share'
    'available funds' 'USD 100000'
    'no shares'()

    when:
    'bought' '10 shares of GOOG'

    then:
    'available funds should be' 'USD 91863.30'
    'should have' '10 shares of GOOG'
  }

  private void 'stock market listing'(String infoAboutListedCompanies) {
    stockMarket = new StockMarket(listedCompaniesBasedOn(infoAboutListedCompanies))
  }

  private void 'available funds'(String funds) {
    initialFunds = Money.parse(funds)
  }

  private void 'no shares'() {
    initialShares = []
  }

  private void 'bought'(String infoAboutBoughtCompanyShares) {
    coati = new Coati(stockMarket, initialFunds, initialShares)
    coati = coati.bought(companySharesBasedOn(infoAboutBoughtCompanyShares))
  }

  private void 'available funds should be'(String expectedFunds) {
    assert coati.funds() == Money.parse(expectedFunds)
  }

  private void 'should have'(String expectedShares) {
    assert coati.portfolio() == Portfolio.with(companySharesBasedOn(expectedShares))
  }

}
