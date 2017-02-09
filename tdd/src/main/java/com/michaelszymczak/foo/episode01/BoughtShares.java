package com.michaelszymczak.foo.episode01;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class BoughtShares extends Value {

  private final Set<CompanyShares> shares;

  public static class None extends BoughtShares
  {
    public None() {
      super(ImmutableSet.of());
    }
  }

  public BoughtShares(Set<CompanyShares> shares) {
    this.shares = ImmutableSet.copyOf(shares);
  }

  public int totalPriceOn(StockMarket stockMarket)
  {
    return shares.stream().mapToInt(share -> share.worthOn(stockMarket)).sum();
  }

  public BoughtShares withMore(BoughtShares newlyBoughtShares)
  {
    return new BoughtShares(groupedByCompany(existingWith(newlyBoughtShares)));
  }

  private ImmutableList<CompanyShares> existingWith(BoughtShares boughtShares) {
    return new ImmutableList.Builder<CompanyShares>()
            .addAll(this.shares)
            .addAll(boughtShares.shares)
            .build();
  }

  private static Set<CompanyShares> groupedByCompany(ImmutableList<CompanyShares> shares) {
    return shares.stream()
            .collect(groupingBy(CompanyShares::getCompany, summingInt(CompanyShares::getQuantity)))
            .entrySet().stream()
            .map(e -> new CompanyShares(e.getKey(), e.getValue()))
            .collect(Collectors.toSet());
  }
}
