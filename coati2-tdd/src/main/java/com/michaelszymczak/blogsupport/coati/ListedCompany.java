package com.michaelszymczak.blogsupport.coati;

import com.michaelszymczak.blogsupport.coati.support.Value;
import org.joda.money.Money;

import static com.google.common.base.Preconditions.checkNotNull;

public class ListedCompany extends Value {

  private final Ticker company;
  private final Money pricePerShare;

  public static ListedCompany withPricePerShare(Ticker company, Money pricePerShare) {
    return  new ListedCompany(company, pricePerShare);
  }

  public ListedCompany(Ticker company, Money pricePerShare) {
    this.company = checkNotNull(company);
    this.pricePerShare = checkNotNull(pricePerShare);
  }
}
