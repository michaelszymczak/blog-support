package com.michaelszymczak.foo.episode01;

public class Portfolio {

  private final Funds funds;

  public static Portfolio emptyWithoutFunds()
  {
    return new Portfolio(Funds.ofValue(0));
  }

  private Portfolio(Funds funds) {
    this.funds = funds;
  }

  public static Portfolio investingOn(Object stockMarket) {
    return Portfolio.emptyWithoutFunds();
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

  public Portfolio afterBuying(String stocks) {
    return new Portfolio(Funds.ofValue(100));
  }
}
