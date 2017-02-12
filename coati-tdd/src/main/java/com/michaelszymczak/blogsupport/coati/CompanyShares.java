package com.michaelszymczak.blogsupport.coati;

public class CompanyShares extends Value {

  private final String ticker;
  private final int howMany;

  public CompanyShares(String ticker, int howMany) {
    this.ticker = ticker;
    this.howMany = howMany;
  }

  public static CompanyShares of(String ticker, int howMany) {
    return new CompanyShares(ticker, howMany);
  }

  public String ticker() {
    return ticker;
  }
}
