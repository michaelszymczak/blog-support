package com.michaelszymczak.blogsupport.coati.support

import com.michaelszymczak.blogsupport.coati.ListedCompany
import com.michaelszymczak.blogsupport.coati.Ticker
import org.joda.money.Money
import spock.lang.Specification

class ListedCompanyFixturesTest extends Specification {
  def "should parse listed companies"() {
    expect:
    ListedCompanyFixtures.listedCompaniesBasedOn(input) == expectedListedCompanies

    where:
    input                            | expectedListedCompanies
    'GOOG sold USD 813.67 per share' | [new ListedCompany(ticker("GOOG"), Money.parse('USD 813.67'))]
    'TWTR sold USD 15.58 per share'  | [new ListedCompany(ticker("TWTR"), Money.parse('USD 15.58'))]
  }

  def "should parse multiple listed companies"() {
    expect:
    ListedCompanyFixtures.listedCompaniesBasedOn(
            'GOOG sold USD 813.67 per share and TWTR sold USD 15.58 per share and ZZZZ sold USD 1 per share'
    ) == [
            new ListedCompany(ticker("GOOG"), Money.parse('USD 813.67')),
            new ListedCompany(ticker("TWTR"), Money.parse('USD 15.58')),
            new ListedCompany(ticker("ZZZZ"), Money.parse('USD 1'))
    ]

    ListedCompanyFixtures.listedCompaniesBasedOn(
            'GOOG sold USD 813.67 per share and ZZZZ sold USD 1 per share'
    ) == [
            new ListedCompany(ticker("GOOG"), Money.parse('USD 813.67')),
            new ListedCompany(ticker("ZZZZ"), Money.parse('USD 1'))
    ]
  }

  private static Ticker ticker(String code) {
    new Ticker(code)
  }
}
