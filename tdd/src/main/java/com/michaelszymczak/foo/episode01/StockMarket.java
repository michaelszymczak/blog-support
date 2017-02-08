package com.michaelszymczak.foo.episode01;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

public class StockMarket {

  private final Set<Share> listedCompanies;

  public StockMarket(Set<Share> listedCompanies) {
    this.listedCompanies = ImmutableSet.copyOf(listedCompanies);
  }

  public static StockMarket trading(Set<Share> companies)
  {
    return new StockMarket(companies);
  }

  public Share.PricePerShare priceOf(final Share.Ticker share) {
    return listedCompanies.stream()
            .filter(it -> it.matches(share))
            .map(Share::pricePerShare)
            .findAny()
            .get();
  }
}
