package com.michaelszymczak.foo.episode01;

public class Share {

  public static Builder withTicker(String ticker)
  {
    return new Builder(new Ticker(ticker));
  }

  public static Ticker ticker(String ticker)
  {
    return new Ticker(ticker);
  }

  private Share(Ticker ticker, PricePerShare pricePerShare) {
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

    public Share andPricePerShare(int value)
    {
      return new Share(ticker, new PricePerShare(value));
    }
  }
}
