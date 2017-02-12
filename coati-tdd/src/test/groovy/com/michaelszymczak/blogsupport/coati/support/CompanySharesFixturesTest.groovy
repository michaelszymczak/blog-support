package com.michaelszymczak.blogsupport.coati.support

import com.michaelszymczak.blogsupport.coati.CompanyShares
import spock.lang.Specification

import static com.michaelszymczak.blogsupport.coati.support.CompanySharesFixtures.companySharesBasedOn

class CompanySharesFixturesTest extends Specification {
  def "should parse company shares"() {
    expect:
    companySharesBasedOn(input) == expectedCompanyShares

    where:
    input               | expectedCompanyShares
    '10 shares of GOOG' | [CompanyShares.of("GOOG", 10)]
    '15 shares of TWTR' | [CompanyShares.of("TWTR", 15)]
  }

  def "should parse multiple company shares"() {
    expect:
    companySharesBasedOn(
            '10 shares of GOOG and 15 shares of TWTR'
    ) == [
            CompanyShares.of("GOOG", 10),
            CompanyShares.of("TWTR", 15)
    ]
  }
}
