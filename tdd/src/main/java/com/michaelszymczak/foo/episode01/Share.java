package com.michaelszymczak.foo.episode01;

public class Share extends Value {

  private final Ticker ticker;

  private final PricePerShare pricePerShare;

  private Share(Ticker ticker, PricePerShare pricePerShare) {
    this.ticker = ticker;
    this.pricePerShare = pricePerShare;
  }

  public static Builder withTicker(String ticker)
  {
    return new Builder(new Ticker(ticker));
  }

  public static Builder identifiedBy(Ticker ticker)
  {
    return new Builder(ticker);
  }

  public static Ticker ticker(String ticker)
  {
    return new Ticker(ticker);
  }

  public boolean matches(Ticker ticker)
  {
    return this.ticker.equals(ticker);
  }

  public PricePerShare pricePerShare()
  {
    return pricePerShare;
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
