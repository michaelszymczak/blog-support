package com.michaelszymczak.blogsupport.coati;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.stream.Collectors;

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
    this.shares = copyOf(new Grouped(shares).shares());
  }

  public Assets withAdditional(List<CompanyShares> shares) {
    final List<CompanyShares> sharesAfterTransaction = new ImmutableList.Builder<CompanyShares>()
            .addAll(this.shares)
            .addAll(shares)
            .build();

    return Assets.of(sharesAfterTransaction);
  }

  private static class Grouped extends Value {
    private final List<CompanyShares> shares;

    public Grouped(List<CompanyShares> shares) {
      this.shares = checkNotNull(shares);
    }

    List<CompanyShares> shares()
    {
      return shares.stream()
              .collect(Collectors.groupingBy(CompanyShares::ticker, Collectors.toList()))
              .entrySet().stream()
              .map(company -> CompanyShares.of(company.getKey(), company.getValue().stream().mapToLong(CompanyShares::howMany).sum()))
              .collect(Collectors.toList());
    }
  }
}
