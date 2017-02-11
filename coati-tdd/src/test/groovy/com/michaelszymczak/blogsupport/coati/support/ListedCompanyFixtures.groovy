package com.michaelszymczak.blogsupport.coati.support

import com.michaelszymczak.blogsupport.coati.ListedCompany
import org.joda.money.Money

class ListedCompanyFixtures {

  private static final String PATTERN = "(.+) sold (.+) per share"
  private final String input

  static List<ListedCompany> listedCompaniesBasedOn(String infoAboutListedCompanies)
  {
    new ListedCompanyFixtures(infoAboutListedCompanies).listedCompanies()
  }

  ListedCompanyFixtures(String input) {
    this.input = input
  }

  List<ListedCompany> listedCompanies() {
    def data = extracted()

    assert data.size() == 3
    String ticker = data[1]
    String price = data[2]

    [new ListedCompany(ticker, Money.parse(price))]
  }

  private List extracted() {
    (input =~ PATTERN)[0] as List
  }
}
