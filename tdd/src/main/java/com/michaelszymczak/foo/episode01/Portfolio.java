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

  public boolean hasFunds() {
    return funds.available();
  }

  public Portfolio afterAdding(Funds fundsToAdd) {
    return new Portfolio(fundsToAdd);
  }
}
