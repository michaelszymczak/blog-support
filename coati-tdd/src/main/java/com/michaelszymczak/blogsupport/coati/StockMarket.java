package com.michaelszymczak.blogsupport.coati;

import java.util.List;

public class StockMarket extends Value {

  public StockMarket(List<ListedCompany> listedCompanies) {
  }

  public static StockMarket listing(List<ListedCompany> listedCompanies) {
    return new StockMarket(listedCompanies);
  }
}
