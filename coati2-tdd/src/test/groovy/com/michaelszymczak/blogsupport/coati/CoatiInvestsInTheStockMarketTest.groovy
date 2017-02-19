package com.michaelszymczak.blogsupport.coati

import com.michaelszymczak.blogsupport.coati.support.CompanySharesFixtures
import com.michaelszymczak.blogsupport.coati.support.ListedCompanyFixtures
import org.joda.money.Money
import spock.lang.Specification

import static com.michaelszymczak.blogsupport.coati.support.CompanySharesFixtures.companySharesBasedOn
import static com.michaelszymczak.blogsupport.coati.support.ListedCompanyFixtures.listedCompaniesBasedOn

class CoatiInvestsInTheStockMarketTest extends Specification {
  def "buy some shares having enough funds"() {
    given:
    'stock market listing' 'GOOG sold USD 813.67 per share'
    'available funds of' 'USD 100000'
    'assets of' '0 shares of GOOG'

    when:
    'bought' '10 shares of GOOG'

    then:
    'available funds should be' 'USD 91863.30'
    'should have' '10 shares of GOOG'
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
