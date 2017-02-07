package com.michaelszymczak.foo.episode01;

public class Company {

  public static Builder withTicker(String ticker)
  {
    return new Builder(new Ticker(ticker));
  }

  public Company(Ticker ticker, PricePerShare pricePerShare) {
  }

  public static class Ticker {
    public Ticker(String ticker) {
    }
  }

  public static class PricePerShare {
    public PricePerShare(int price) {
    }
  }

  public static class Builder
  {
    private Ticker ticker;

    public Builder(Ticker ticker) {
    }

    public Company andPricePerShare(int value)
    {
      return new Company(ticker, new PricePerShare(value));
    }
  }
}
