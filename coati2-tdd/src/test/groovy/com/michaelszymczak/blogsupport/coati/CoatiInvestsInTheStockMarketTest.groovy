package com.michaelszymczak.blogsupport.coati

import org.joda.money.Money
import spock.lang.Specification

import static com.michaelszymczak.blogsupport.coati.support.CompanySharesFixtures.companySharesBasedOn
import static com.michaelszymczak.blogsupport.coati.support.ListedCompanyFixtures.listedCompaniesBasedOn

class CoatiInvestsInTheStockMarketTest extends Specification {
  def "buy some shares having enough funds"() {
    given:
    'stock market listing' 'GOOG sold USD 813.67 per share'
    'available funds of' initialFunds
    'assets of' initialAssets

    when:
    'bought' boughtShares

    then:
    'available funds should be' expectedFunds
    'should have' expectedAssets

    where:
    initialFunds | initialAssets      | boughtShares        | expectedFunds  | expectedAssets
    'USD 100000' | '0 shares of GOOG' | '10 shares of GOOG' | 'USD 91863.30' | '10 shares of GOOG'
  //'USD 100000' | '0 shares of GOOG' | '1 shares of GOOG'  | 'USD 99186.33' | '1 shares of GOOG' // TODO
  }

  private void 'stock market listing'(String infoAboutListedCompanies) {
    stockMarket = StockMarket.listing(listedCompaniesBasedOn(infoAboutListedCompanies))
  }

  private void 'available funds of'(String availableFunds) {
    availableFundsBeforeTransaction = Money.parse(availableFunds)
  }

  private void 'assets of'(String infoAboutShares) {
    assetsBeforeTransaction = Assets.with(companySharesBasedOn(infoAboutShares))
  }

  private void 'bought'(String purchase) {
    coati.addPortfolioFor(user, Portfolio.with(assetsBeforeTransaction, availableFundsBeforeTransaction))
    coati.buyFor(user, Assets.with(companySharesBasedOn(purchase)))
  }

  private void 'available funds should be'(String infoAboutExpectedFunds) {
    expectedFundsAfterTransaction = Money.parse(infoAboutExpectedFunds)
  }

  private void 'should have'(String infoAboutExpectedShares) {
    expectedAssetsAfterTransaction = Assets.with(companySharesBasedOn(infoAboutExpectedShares))

    assert coati.portfolioOf(user) == Portfolio.with(expectedAssetsAfterTransaction, expectedFundsAfterTransaction)
  }

  private User user = new User()

  private Coati coati = new Coati()
  private StockMarket stockMarket
  private Money availableFundsBeforeTransaction
  private Assets assetsBeforeTransaction
  private Assets expectedAssetsAfterTransaction
  private Money expectedFundsAfterTransaction
}
