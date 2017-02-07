package com.michaelszymczak.foo.episode01;

public class Portfolio {

  private final boolean noFunds;

  public Portfolio() {
    this(true);
  }

  public Portfolio(boolean noFunds) {
    this.noFunds = noFunds;
  }

  public boolean noShares() {
    return true;
  }

  public boolean noFunds() {
    return noFunds;
  }

  public Portfolio afterAdding(Funds fundsToAdd) {
    return new Portfolio(false);
  }
}
