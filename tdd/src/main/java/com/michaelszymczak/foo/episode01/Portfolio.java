package com.michaelszymczak.foo.episode01;

public class Portfolio {

  private final boolean hasFunds;

  public static Portfolio emptyWithoutFunds()
  {
    return new Portfolio(false);
  }

  private Portfolio(boolean hasFunds) {
    this.hasFunds = hasFunds;
  }

  public boolean noFunds() {
    return !hasFunds;
  }

  public boolean hasFunds() {
    return hasFunds;
  }

  public Portfolio afterAdding(Funds fundsToAdd) {
    return new Portfolio(true);
  }
}
