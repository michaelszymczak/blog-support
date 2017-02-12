package com.michaelszymczak.blogsupport.coati.support

import com.michaelszymczak.blogsupport.coati.ListedCompany

import com.michaelszymczak.blogsupport.coati.support.parsing.ExtractedData
import com.michaelszymczak.blogsupport.coati.support.parsing.SplittingPattern
import org.joda.money.Money

import static com.michaelszymczak.blogsupport.coati.support.parsing.ExtractedData.data

class ListedCompanyFixtures {

  private static final SplittingPattern PATTERN = { "(.+) sold (.+) per share" }
  private final ExtractedData data

  static List<ListedCompany> listedCompaniesBasedOn(String infoAboutListedCompanies) {
    new ListedCompanyFixtures(infoAboutListedCompanies).listedCompanies()
  }

  private ListedCompanyFixtures(String input) {
    this.data = data(PATTERN, input)
  }

  private List<ListedCompany> listedCompanies() {
    data.extracted().collect {
      new ListedCompany(it[0] as String, Money.parse(it[1] as String))
    }
  }
}
