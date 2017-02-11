package com.michaelszymczak.blogsupport.coati;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.ImmutableList.copyOf;

public class Portfolio {

  private final List<CompanyShares> shares;

  static Portfolio with(List<CompanyShares> shares)
  {
    return new Portfolio(shares);
  }

  public Portfolio(List<CompanyShares> shares) {
    this.shares = copyOf(checkNotNull(shares));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Portfolio portfolio = (Portfolio) o;

    return shares != null ? shares.equals(portfolio.shares) : portfolio.shares == null;

  }

  @Override
  public int hashCode() {
    return shares != null ? shares.hashCode() : 0;
  }
}
