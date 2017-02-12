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
    'stock market listing' companies
    'available funds of' someInitialAmount
    'no shares'()

    when:
    'bought' someShares

    then:
    'available funds should be' initialFundsAfterBuyingSomeShares
    'should have' someShares

    where:
    companies                        | someInitialAmount | someShares          | initialFundsAfterBuyingSomeShares
    'GOOG sold USD 813.67 per share' | 'USD 100000'      | '10 shares of GOOG' | 'USD 91863.30'
 // 'TWTR sold USD 1 per share'      | 'USD 10'          | '5 shares of TWTR'  | 'USD 5' // TODO
  }

  private void 'stock market listing'(String infoAboutListedCompanies) {
    stockMarket = StockMarket.listing(listedCompaniesBasedOn(infoAboutListedCompanies))
  }

  private void 'available funds of'(String funds) {
    initialFunds = Money.parse(funds)
  }

  private void 'no shares'() {
    initialShares = []
  }

  private void 'bought'(String infoAboutBoughtCompanyShares) {
    coati = Coati.createForNewPlayer("foo", stockMarket, initialFunds, initialShares)
    coati.bought("foo", companySharesBasedOn(infoAboutBoughtCompanyShares))
  }

  private void 'available funds should be'(String expectedFunds) {
    assert coati.funds() == Money.parse(expectedFunds)
  }

  private void 'should have'(String expectedShares) {
    assert coati.shares() == companySharesBasedOn(expectedShares)
  }

}
