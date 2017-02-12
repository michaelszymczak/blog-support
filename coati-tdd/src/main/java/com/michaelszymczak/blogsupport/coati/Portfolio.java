package com.michaelszymczak.blogsupport.coati;

import org.joda.money.Money;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.ImmutableList.copyOf;

public class Portfolio extends Value {

  private final Money funds;
  private final List<CompanyShares> shares;

  static Portfolio with(Money funds, List<CompanyShares> shares)
  {
    return new Portfolio(funds, shares);
  }

  public Portfolio(Money funds, List<CompanyShares> shares) {
    this.funds = checkNotNull(funds);
    this.shares = copyOf(checkNotNull(shares));
  }

  public Money funds() {
    return funds;
  }

  public List<CompanyShares> shares() {
    return shares;
  }

  public Portfolio afterBuying(List<CompanyShares> shares) {
    // TODO
    return this;
  }
}
