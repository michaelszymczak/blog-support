package com.michaelszymczak.blogsupport.coati;

import com.google.common.collect.ImmutableList;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.ImmutableList.copyOf;

public class Assets extends Value {
  private final List<CompanyShares> shares;

  public static Assets of(List<CompanyShares> shares) {
    return new Assets(shares);
  }

  public static Assets noAssets() {
    return new Assets(ImmutableList.of());
  }

  private Assets(List<CompanyShares> shares) {
    this.shares = copyOf(checkNotNull(shares));
  }

  public Assets withAdditional(List<CompanyShares> shares) {
    final List<CompanyShares> sharesAfterTransaction = new ImmutableList.Builder<CompanyShares>()
            .addAll(this.shares)
            .addAll(shares)
            .build();

    return Assets.of(sharesAfterTransaction);
  }
}
