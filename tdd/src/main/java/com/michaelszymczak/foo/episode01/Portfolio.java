package com.michaelszymczak.foo.episode01;

import java.util.List;

public class Portfolio {

  private final Funds funds;
  private final StockMarket stockMarket;
  private final BoughtShares boughtShares;

  private Portfolio(StockMarket stockMarket, Funds funds) {
    this.funds = funds;
    this.stockMarket = stockMarket;
    this.boughtShares = new BoughtShares.None();
  }

  private Portfolio(StockMarket stockMarket, Funds funds, BoughtShares boughtShares) {
    this.funds = funds;
    this.stockMarket = stockMarket;
    this.boughtShares = boughtShares;
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

  public Portfolio afterBuying(List<CompanyShares> newCompanyShares) {

    int totalPrice = newCompanyShares.stream().mapToInt(share -> share.worthOn(stockMarket)).sum();

    return new Portfolio(
            stockMarket,
            funds.withSubtracted(Funds.ofValue(totalPrice)),
            boughtShares.withSomeMore(newCompanyShares)
    );
  }

  public List<CompanyShares> shares() {
    return boughtShares.getShares();
  }
}
