package com.michaelszymczak.foo.episode01;

public class CompanyShares extends Value
{
  private final Ticker company;
  private final int quantity;

  public CompanyShares(Ticker company, int quantity) {
    this.company = company;
    this.quantity = quantity;
  }

  public int worthOn(StockMarket stockMarket) {
    return stockMarket.priceOf(company).value() * quantity;
  }

  public Ticker getCompany() {
    return company;
  }

  public int getQuantity() {
    return quantity;
  }
}
