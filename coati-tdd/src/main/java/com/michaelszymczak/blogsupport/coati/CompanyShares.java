package com.michaelszymczak.blogsupport.coati;

import static com.google.common.base.Preconditions.checkNotNull;

public class CompanyShares extends Value {

  private final Ticker ticker;
  private final long howMany;

  public CompanyShares(Ticker ticker, long howMany) {
    this.ticker = checkNotNull(ticker);
    this.howMany = howMany;
  }

  public static CompanyShares of(Ticker ticker, long howMany) {
    return new CompanyShares(ticker, howMany);
  }

  public Ticker ticker() {
    return ticker;
  }

  public long howMany() {
    return howMany;
  }
}
