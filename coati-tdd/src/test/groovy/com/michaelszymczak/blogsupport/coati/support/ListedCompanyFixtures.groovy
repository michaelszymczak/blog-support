package com.michaelszymczak.blogsupport.coati.support

import com.michaelszymczak.blogsupport.coati.ListedCompany
import com.michaelszymczak.blogsupport.coati.support.parsing.ExtractedData
import org.joda.money.Money

class ListedCompanyFixtures {

  private final ExtractedData data

  static List<ListedCompany> listedCompaniesBasedOn(String infoAboutListedCompanies) {
    new ListedCompanyFixtures(infoAboutListedCompanies).listedCompanies()
  }

  private ListedCompanyFixtures(String input) {
    this.data = ExtractedData.data("(.+)", "(.+) sold (.+) per share", input)
  }

  List<ListedCompany> listedCompanies() {
    List extracted = data.extracted()[0] as List

    String ticker = extracted[0]
    String price = extracted[1]

    [new ListedCompany(ticker, Money.parse(price))]
  }
}
