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
}
