package com.michaelszymczak.blogsupport.coati.support

import com.michaelszymczak.blogsupport.coati.ListedCompany
import org.joda.money.Money
import spock.lang.Specification

class ListedCompanyFixturesTest extends Specification {
  def "should parse listed companies"() {
    expect:
    new ListedCompanyFixtures(input).listedCompanies() == expectedListedCompanies

    where:
    input                            | expectedListedCompanies
    'GOOG sold USD 813.67 per share' | [new ListedCompany("GOOG", Money.parse('USD 813.67'))]
  }
}
