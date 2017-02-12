package com.michaelszymczak.blogsupport.coati;

import static com.google.common.base.Preconditions.checkNotNull;

public class CompanyShares extends Value {

  private final Ticker ticker;
  private final int howMany;

  public CompanyShares(Ticker ticker, int howMany) {
    this.ticker = checkNotNull(ticker);
    this.howMany = howMany;
  }

  public static CompanyShares of(Ticker ticker, int howMany) {
    return new CompanyShares(ticker, howMany);
  }

  public Ticker ticker() {
    return ticker;
  }

  public int howMany() {
    return howMany;
  }
}
