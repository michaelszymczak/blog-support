package com.michaelszymczak.blogsupport.coati;

import com.google.common.collect.ImmutableList;
import com.michaelszymczak.blogsupport.coati.support.Value;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class Portfolio extends Value {

  private final List<CompanyShares> shares;

  public static Portfolio with(List<CompanyShares> shares) {
    return new Portfolio(shares);
  }

  public Portfolio(List<CompanyShares> shares) {
    this.shares = ImmutableList.copyOf(checkNotNull(shares));
  }
}
