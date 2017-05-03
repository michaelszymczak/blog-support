package com.michaelszymczak.blogsupport.coati;

import com.michaelszymczak.blogsupport.coati.support.Value;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.ImmutableList.copyOf;

public class Assets extends Value {

  private final List<CompanyShares> shares;

  public static Assets with(List<CompanyShares> shares)
  {
    return new Assets(shares);
  }

  public Assets(List<CompanyShares> shares) {
    this.shares = copyOf(checkNotNull(shares));
  }
}
