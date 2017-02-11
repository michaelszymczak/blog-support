package com.michaelszymczak.blogsupport.episode01;

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

  public Portfolio after(BoughtShares newlyBoughtShares) {
    return new Portfolio(
            stockMarket,
            funds.withSubtracted(Funds.ofValue(newlyBoughtShares.totalPriceOn(stockMarket))),
            boughtShares.withMore(newlyBoughtShares)
    );
  }

  public BoughtShares shares() {
    return boughtShares;
  }

}
