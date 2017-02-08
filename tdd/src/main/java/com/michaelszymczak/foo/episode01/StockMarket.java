package com.michaelszymczak.foo.episode01;

import java.util.Set;

public class StockMarket {

  public static StockMarket trading(Set<Share> companies)
  {
    return new StockMarket();
  }

  public int priceOf(Share.Ticker share) {
    return 20;
  }
}
