package com.michaelszymczak.blogsupport.coati.support

import com.michaelszymczak.blogsupport.coati.CompanyShares
import spock.lang.Specification

class CompanySharesFixturesTest extends Specification {
  def "should parse company shares"() {
    expect:
    new CompanySharesFixtures(input).companyShares() == expectedCompanyShares

    where:
    input               | expectedCompanyShares
    '10 shares of GOOG' | [CompanyShares.of("GOOG", 10)]
    '15 shares of TWTR' | [CompanyShares.of("TWTR", 15)]
  }
}
