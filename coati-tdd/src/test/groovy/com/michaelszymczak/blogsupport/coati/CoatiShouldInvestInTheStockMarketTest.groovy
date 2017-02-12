package com.michaelszymczak.blogsupport.coati

import org.joda.money.Money
import spock.lang.Specification

import static com.michaelszymczak.blogsupport.coati.support.CompanySharesFixtures.companySharesBasedOn
import static com.michaelszymczak.blogsupport.coati.support.ListedCompanyFixtures.listedCompaniesBasedOn

class CoatiShouldInvestInTheStockMarketTest extends Specification {

  private final String PLAYER = "foo"

  private Coati coati
  private StockMarket stockMarket
  private Money initialFunds
  private List<CompanyShares> initialShares

  private Money expectedAvailableFunds
  private List<CompanyShares> expectedShares

  def "buy some shares having enough funds"() {
    given:
    'stock market listing' companies
    'available funds of' someInitialAmount
    'shares' sharesBeforeTransaction

    when:
    'bought' someSharesToBuy

    then:
    'available funds should be' remainingFunds
    'should have' sharesAfterTransaction

    where:
    companies                                                 | someInitialAmount | sharesBeforeTransaction | someSharesToBuy                         | sharesAfterTransaction                  | remainingFunds
    'GOOG sold USD 813.67 per share'                          | 'USD 100000'      | ''                      | '10 shares of GOOG'                     | '10 shares of GOOG'                     | 'USD 91863.30'
    'TWTR sold USD 1 per share'                               | 'USD 10'          | ''                      | '5 shares of TWTR'                      | '5 shares of TWTR'                      | 'USD 5'
    'GOOG sold USD 3 per share and TWTR sold USD 4 per share' | 'USD 100'         | ''                      | '2 shares of TWTR and 3 shares of GOOG' | '2 shares of TWTR and 3 shares of GOOG' | 'USD 83'
//    'TWTR sold USD 1 per share'                               | 'USD 10'          | '2 shares of TWTR'      | '5 shares of TWTR'                      | '7 shares of TWTR'                      | 'USD 5'  // TODO
  }

  private void 'stock market listing'(String infoAboutListedCompanies) {
    stockMarket = StockMarket.listing(listedCompaniesBasedOn(infoAboutListedCompanies))
  }

  private void 'available funds of'(String funds) {
    initialFunds = Money.parse(funds)
  }

  private void 'shares'(String shares) {
    initialShares = companySharesBasedOn(shares)
  }

  private void 'bought'(String infoAboutBoughtCompanyShares) {
    coati = Coati.createForNewPlayer(PLAYER, stockMarket, initialFunds, initialShares)
    coati.bought("foo", companySharesBasedOn(infoAboutBoughtCompanyShares))
  }

  private void 'available funds should be'(String expectedFunds) {
    expectedAvailableFunds = Money.parse(expectedFunds)
  }

  private void 'should have'(String shares) {
    expectedShares = companySharesBasedOn(shares)

    assert coati.portfolio(PLAYER) == Portfolio.tradingOn(stockMarket)
            .with(expectedAvailableFunds, expectedShares)
  }

}
