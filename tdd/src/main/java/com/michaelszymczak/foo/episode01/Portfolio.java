package com.michaelszymczak.foo.episode01;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class Portfolio {

  private final Funds funds;
  private final StockMarket stockMarket;
  private final List<CompanyShares> shares;

  private Portfolio(StockMarket stockMarket, Funds funds) {
    this.funds = funds;
    this.stockMarket = stockMarket;
    this.shares = ImmutableList.of();
  }

  private Portfolio(StockMarket stockMarket, Funds funds, List<CompanyShares> shares) {
    this.funds = funds;
    this.stockMarket = stockMarket;
    this.shares = ImmutableList.copyOf(shares);
  }

  public static Portfolio investingOn(StockMarket stockMarket) {
    return new Portfolio(stockMarket, Funds.ofValue(0));
  }

  public boolean hasFunds() {
    return funds.available();
  }

  public Portfolio afterAdding(Funds fundsToAdd) {
    return new Portfolio(stockMarket, funds.withAdded(fundsToAdd));
  }

  public Funds availableFunds() {
    return funds;
  }

  public Portfolio afterBuying(List<CompanyShares> companyShares) {

    int totalPrice = companyShares.stream()
            .mapToInt(share -> stockMarket.priceOf(share.getCompany()).value() * share.getQuantity())
            .sum();

    return new Portfolio(
            stockMarket,
            funds.withSubtracted(Funds.ofValue(totalPrice)),
            companyShares
    );
  }

  public List<CompanyShares> shares() {
    return shares;
  }
}
