package com.michaelszymczak.blogsupport.coati.support

import com.michaelszymczak.blogsupport.coati.ListedCompany
import org.joda.money.Money
import spock.lang.Specification

class ListedCompanyFixturesTest extends Specification {
  def "should parse listed companies"() {
    expect:
    new ListedCompanyFixtures('GOOG sold USD 813.67 per share').listedCompanies() == [new ListedCompany("GOOG", Money.parse('USD 813.67'))]
  }
}
