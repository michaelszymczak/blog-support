package com.michaelszymczak.blogsupport.coati;

public class CompanyShares {

  private final String ticker;
  private final int howMany;

  public CompanyShares(String ticker, int howMany) {
    this.ticker = ticker;
    this.howMany = howMany;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CompanyShares that = (CompanyShares) o;

    if (howMany != that.howMany) return false;
    return ticker != null ? ticker.equals(that.ticker) : that.ticker == null;

  }

  @Override
  public int hashCode() {
    int result = ticker != null ? ticker.hashCode() : 0;
    result = 31 * result + howMany;
    return result;
  }

  public static CompanyShares of(String ticker, int howMany) {
    return new CompanyShares(ticker, howMany);
  }

  @Override
  public String toString() {
    return "CompanyShares{" +
            "ticker='" + ticker + '\'' +
            ", howMany=" + howMany +
            '}';
  }
}
