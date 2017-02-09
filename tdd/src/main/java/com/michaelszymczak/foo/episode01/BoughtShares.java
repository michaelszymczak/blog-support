package com.michaelszymczak.foo.episode01;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class BoughtShares extends Value {
  private final List<CompanyShares> shares;

  public BoughtShares(List<CompanyShares> shares) {
    this.shares = ImmutableList.copyOf(shares);
  }

  public List<CompanyShares> getShares() {
    return shares;
  }

  public BoughtShares withSomeMore(List<CompanyShares> companyShares)
  {
    return new BoughtShares(new ImmutableList.Builder<CompanyShares>()
            .addAll(shares)
            .addAll(companyShares)
            .build());
  }

  public static class None extends BoughtShares
  {
    public None() {
      super(ImmutableList.of());
    }
  }
}
