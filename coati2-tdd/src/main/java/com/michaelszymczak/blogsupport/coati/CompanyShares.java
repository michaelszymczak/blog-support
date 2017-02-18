package com.michaelszymczak.blogsupport.coati;

import com.michaelszymczak.blogsupport.coati.support.Value;

public class CompanyShares extends Value {

  private final Ticker ticker;
  private final int howMany;

  public static CompanyShares of(Ticker ticker, int howMany) {
    return new CompanyShares(ticker, howMany);
  }

  private CompanyShares(Ticker ticker, int howMany) {
    this.ticker = ticker;
    this.howMany = howMany;
  }
}
