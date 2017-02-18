package com.michaelszymczak.blogsupport.coati;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.ImmutableList.copyOf;

public class StockMarket {

  private final List<ListedCompany> listedCompanies;

  public static StockMarket listing(List<ListedCompany> listedCompanies) {
    return new StockMarket(listedCompanies);
  }

  public StockMarket(List<ListedCompany> listedCompanies) {
    this.listedCompanies = copyOf(checkNotNull(listedCompanies));
  }
}
