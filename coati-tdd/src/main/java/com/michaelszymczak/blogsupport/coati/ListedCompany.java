package com.michaelszymczak.blogsupport.coati;

import org.joda.money.Money;

public class ListedCompany extends Value {

  private final String ticker;
  private final Money pricePerShare;

  public ListedCompany(String ticker, Money pricePerShare) {
    this.ticker = ticker;
    this.pricePerShare = pricePerShare;
  }

  public String ticker() {
    return ticker;
  }

  public Money pricePerShare() {
    return pricePerShare;
  }
}
