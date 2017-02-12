package com.michaelszymczak.blogsupport.coati;

import org.joda.money.Money;

import static com.google.common.base.Preconditions.checkNotNull;

public class ListedCompany extends Value {

  private final Ticker ticker;
  private final Money pricePerShare;

  public ListedCompany(Ticker ticker, Money pricePerShare) {
    this.ticker = checkNotNull(ticker);
    this.pricePerShare = pricePerShare;
  }

  public Ticker ticker() {
    return ticker;
  }

  public Money pricePerShare() {
    return pricePerShare;
  }
}
