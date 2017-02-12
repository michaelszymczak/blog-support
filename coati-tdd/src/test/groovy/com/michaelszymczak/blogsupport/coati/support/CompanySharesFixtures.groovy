package com.michaelszymczak.blogsupport.coati.support

import com.michaelszymczak.blogsupport.coati.CompanyShares
import com.michaelszymczak.blogsupport.coati.Ticker
import com.michaelszymczak.blogsupport.coati.support.parsing.ExtractedData
import com.michaelszymczak.blogsupport.coati.support.parsing.SplittingPattern

import static com.michaelszymczak.blogsupport.coati.support.parsing.ExtractedData.data

class CompanySharesFixtures {

  private static final SplittingPattern PATTERN = { "(.+) shares of (.+)" }
  private final ExtractedData data

  static List<CompanyShares> companySharesBasedOn(String infoAboutCompanyShares) {
    new CompanySharesFixtures(infoAboutCompanyShares).companyShares()
  }

  private CompanySharesFixtures(String input) {
    this.data = data(PATTERN, input)
  }

  List<CompanyShares> companyShares() {
    data.extracted().collect {
      CompanyShares.of(new Ticker(it[1] as String), Integer.parseInt(it[0] as String))
    }
  }
}
