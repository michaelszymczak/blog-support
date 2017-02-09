package com.michaelszymczak.foo.episode01;

public class CompanyShares
{
  private final Share.Ticker company;
  private final int quantity;

  public CompanyShares(Share.Ticker company, int quantity) {
    this.company = company;
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CompanyShares that = (CompanyShares) o;

    if (quantity != that.quantity) return false;
    return company != null ? company.equals(that.company) : that.company == null;

  }

  @Override
  public int hashCode() {
    int result = company != null ? company.hashCode() : 0;
    result = 31 * result + quantity;
    return result;
  }
}
