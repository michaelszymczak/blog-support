package com.michaelszymczak.foo.episode01;

public class Share {

  private final Ticker ticker;
  private final PricePerShare pricePerShare;

  public static Builder withTicker(String ticker)
  {
    return new Builder(new Ticker(ticker));
  }

  public static Ticker ticker(String ticker)
  {
    return new Ticker(ticker);
  }

  private Share(Ticker ticker, PricePerShare pricePerShare) {
    this.ticker = ticker;
    this.pricePerShare = pricePerShare;
  }

  public boolean matches(Ticker ticker)
  {
    return this.ticker.equals(ticker);
  }

  public PricePerShare pricePerShare()
  {
    return pricePerShare;
  }

  public static class Ticker {
    private final String ticker;

    public Ticker(String ticker) {
      this.ticker = ticker;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Ticker ticker1 = (Ticker) o;

      return ticker != null ? ticker.equals(ticker1.ticker) : ticker1.ticker == null;

    }

    @Override
    public int hashCode() {
      return ticker != null ? ticker.hashCode() : 0;
    }
  }

  public static class PricePerShare {
    private final int price;
    public PricePerShare(int price) {
      this.price = price;
    }

    @Override
    public String toString() {
      return String.valueOf(price);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      PricePerShare that = (PricePerShare) o;

      return price == that.price;

    }

    @Override
    public int hashCode() {
      return price;
    }
  }

  public static class Builder
  {
    private Ticker ticker;

    public Builder(Ticker ticker) {
      this.ticker = ticker;
    }

    public Share andPricePerShare(int value)
    {
      return new Share(ticker, new PricePerShare(value));
    }
  }
}
