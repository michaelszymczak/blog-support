package com.michaelszymczak.blogsupport.coati;

import org.joda.money.Money;

public class ListedCompany {

  private final String ticker;
  private final Money pricePerShare;

  public ListedCompany(String ticker, Money pricePerShare) {
    this.ticker = ticker;
    this.pricePerShare = pricePerShare;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ListedCompany that = (ListedCompany) o;

    if (ticker != null ? !ticker.equals(that.ticker) : that.ticker != null) return false;
    return pricePerShare != null ? pricePerShare.equals(that.pricePerShare) : that.pricePerShare == null;

  }

  @Override
  public int hashCode() {
    int result = ticker != null ? ticker.hashCode() : 0;
    result = 31 * result + (pricePerShare != null ? pricePerShare.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ListedCompany{" +
            "ticker='" + ticker + '\'' +
            ", pricePerShare=" + pricePerShare +
            '}';
  }
}
