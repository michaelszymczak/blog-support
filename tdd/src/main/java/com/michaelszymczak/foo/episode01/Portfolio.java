package com.michaelszymczak.foo.episode01;

public class Portfolio {

  private final Funds funds;
  private final StockMarket stockMarket;

  private Portfolio(StockMarket stockMarket, Funds funds) {
    this.funds = funds;
    this.stockMarket = stockMarket;
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

  public Portfolio afterBuying(Share.Ticker share) {
    int pricePerShare = stockMarket.priceOf(share).value();

    return new Portfolio(
            stockMarket,
            funds.withSubtracted(Funds.ofValue(pricePerShare)));
  }
}
