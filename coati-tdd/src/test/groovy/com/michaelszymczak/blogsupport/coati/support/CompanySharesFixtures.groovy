package com.michaelszymczak.blogsupport.coati.support

import com.michaelszymczak.blogsupport.coati.CompanyShares

class CompanySharesFixtures {
  private final ExtractedData data

  CompanySharesFixtures(String input) {
    this.data = new ExtractedData("(.+) shares of (.+)", input, 2)
  }

  List<CompanyShares> companyShares() {
    List extracted = data.extracted()
    int howMany = Integer.parseInt(extracted[1] as String)
    String ticker = extracted[2]

    [CompanyShares.of(ticker, howMany)]
  }
}
