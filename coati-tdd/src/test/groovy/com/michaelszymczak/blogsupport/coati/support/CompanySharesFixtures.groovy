package com.michaelszymczak.blogsupport.coati.support

import com.michaelszymczak.blogsupport.coati.CompanyShares
import com.michaelszymczak.blogsupport.coati.support.parsing.ExtractedData

class CompanySharesFixtures {
  private final ExtractedData data

  static List<CompanyShares> companySharesBasedOn(String infoAboutCompanyShares) {
    new CompanySharesFixtures(infoAboutCompanyShares).companyShares()
  }

  private CompanySharesFixtures(String input) {
    this.data = ExtractedData.data("(.+) shares of (.+)", input)
  }

  List<CompanyShares> companyShares() {
    List extracted = data.extracted()
    int howMany = Integer.parseInt(extracted[0] as String)
    String ticker = extracted[1]

    [CompanyShares.of(ticker, howMany)]
  }
}
