package com.michaelszymczak.blogsupport.coati.support

import com.michaelszymczak.blogsupport.coati.ListedCompany
import org.joda.money.Money

class ListedCompanyFixtures {

  private final ExtractedData data

  static List<ListedCompany> listedCompaniesBasedOn(String infoAboutListedCompanies) {
    new ListedCompanyFixtures(infoAboutListedCompanies).listedCompanies()
  }

  private ListedCompanyFixtures(String input) {
    this.data = new ExtractedData("(.+) sold (.+) per share", input)
  }

  List<ListedCompany> listedCompanies() {
    List extracted = data.extracted()

    String ticker = extracted[1]
    String price = extracted[2]

    [new ListedCompany(ticker, Money.parse(price))]
  }
}
