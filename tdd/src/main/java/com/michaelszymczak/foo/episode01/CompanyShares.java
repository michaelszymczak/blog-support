package com.michaelszymczak.foo.episode01;

public class CompanyShares extends Value
{
  private final Share.Ticker company;
  private final int quantity;

  public CompanyShares(Share.Ticker company, int quantity) {
    this.company = company;
    this.quantity = quantity;
  }

  public Share.Ticker getCompany() {
    return company;
  }
}
