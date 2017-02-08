package com.michaelszymczak.foo.episode01;

public class Portfolio {

  private final Funds funds;
//  private final StockMarket stockMarket;

  @Deprecated
  public static Portfolio emptyWithoutFunds()
  {
    return new Portfolio(Funds.ofValue(0));
  }

  private Portfolio(Funds funds) {
    this.funds = funds;
  }

  public static Portfolio investingOn(Object stockMarket) {
    return new Portfolio(Funds.ofValue(0));
  }

  public boolean hasFunds() {
    return funds.available();
  }

  public Portfolio afterAdding(Funds fundsToAdd) {
    return new Portfolio(funds.withAdded(fundsToAdd));
  }

  public Funds availableFunds() {
    return funds;
  }

  public Portfolio afterBuying(Share.Ticker share) {
    return new Portfolio(Funds.ofValue(100));
  }
}
