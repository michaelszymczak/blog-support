package com.michaelszymczak.blogsupport.coati.support

import com.michaelszymczak.blogsupport.coati.CompanyShares
import com.michaelszymczak.blogsupport.coati.support.parsing.ExtractedData
import com.michaelszymczak.blogsupport.coati.support.parsing.SplittingPattern

class CompanySharesFixtures {

  private static final SplittingPattern PATTERN = { "(.+) shares of (.+)" }
  private final ExtractedData data

  static List<CompanyShares> companySharesBasedOn(String infoAboutCompanyShares) {
    new CompanySharesFixtures(infoAboutCompanyShares).companyShares()
  }

  private CompanySharesFixtures(String input) {
    this.data = ExtractedData.data( PATTERN , input)
  }

  List<CompanyShares> companyShares() {
    List extracted = data.extracted()
    int howMany = Integer.parseInt(extracted[0] as String)
    String ticker = extracted[1]

    [CompanyShares.of(ticker, howMany)]
  }
}
