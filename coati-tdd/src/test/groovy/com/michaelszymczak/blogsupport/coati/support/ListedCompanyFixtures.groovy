package com.michaelszymczak.blogsupport.coati.support

import com.michaelszymczak.blogsupport.coati.ListedCompany
import org.joda.money.Money

class ListedCompanyFixtures {

  ListedCompanyFixtures(String input) {
  }

  List<ListedCompany> listedCompanies() {
    [new ListedCompany("GOOG", Money.parse('USD 813.67'))]
  }
}
