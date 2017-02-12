package com.michaelszymczak.blogsupport.coati.support

import com.michaelszymczak.blogsupport.coati.ListedCompany
import org.joda.money.Money
import spock.lang.Specification

class ListedCompanyFixturesTest extends Specification {
  def "should parse listed companies"() {
    expect:
    ListedCompanyFixtures.listedCompaniesBasedOn(input) == expectedListedCompanies

    where:
    input                            | expectedListedCompanies
    'GOOG sold USD 813.67 per share' | [new ListedCompany("GOOG", Money.parse('USD 813.67'))]
    'TWTR sold USD 15.58 per share'  | [new ListedCompany("TWTR", Money.parse('USD 15.58'))]
  }
}
