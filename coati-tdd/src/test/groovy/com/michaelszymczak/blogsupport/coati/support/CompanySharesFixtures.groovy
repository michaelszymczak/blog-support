package com.michaelszymczak.blogsupport.coati.support

import com.michaelszymczak.blogsupport.coati.CompanyShares

class CompanySharesFixtures {
  private static final String PATTERN = "(.+) shares of (.+)"
  private final String input

  CompanySharesFixtures(String input) {
    this.input = input
  }

  List<CompanyShares> companyShares() {
    def data = extracted()

    assert data.size() == 3
    int howMany = Integer.parseInt(data[1] as String)
    String ticker = data[2]

    [CompanyShares.of(ticker, howMany)]
  }


  private List extracted() {
    (input =~ PATTERN)[0] as List
  }
}
