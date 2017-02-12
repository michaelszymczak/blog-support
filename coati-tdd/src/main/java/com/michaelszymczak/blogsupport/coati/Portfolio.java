package com.michaelszymczak.blogsupport.coati;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.ImmutableList.copyOf;

public class Portfolio extends Value {

  private final List<CompanyShares> shares;

  static Portfolio with(List<CompanyShares> shares)
  {
    return new Portfolio(shares);
  }

  public Portfolio(List<CompanyShares> shares) {
    this.shares = copyOf(checkNotNull(shares));
  }
}
