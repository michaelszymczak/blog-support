package com.michaelszymczak.blogsupport.coati.support

import com.michaelszymczak.blogsupport.coati.CompanyShares

class CompanySharesFixtures {
  private final ExtractedData data

  static List<CompanyShares> companySharesBasedOn(String infoAboutCompanyShares) {
    new CompanySharesFixtures(infoAboutCompanyShares).companyShares()
  }

  private CompanySharesFixtures(String input) {
    this.data = new ExtractedData("(.+) shares of (.+)", input)
  }

  List<CompanyShares> companyShares() {
    List extracted = data.extracted()
    int howMany = Integer.parseInt(extracted[0] as String)
    String ticker = extracted[1]

    [CompanyShares.of(ticker, howMany)]
  }
}
