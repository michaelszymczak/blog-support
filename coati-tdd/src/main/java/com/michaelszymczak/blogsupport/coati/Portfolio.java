package com.michaelszymczak.blogsupport.coati;

import com.google.common.collect.ImmutableList;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.ImmutableList.copyOf;

public class Portfolio extends Value {

  private final StockMarket stockMarket;
  private final Money funds;
  private final List<CompanyShares> shares;

  Portfolio with(Money funds, List<CompanyShares> shares)
  {
    return new Portfolio(stockMarket, funds, shares);
  }

  private Portfolio(StockMarket stockMarket, Money funds, List<CompanyShares> shares) {
    this.stockMarket = checkNotNull(stockMarket);
    this.funds = checkNotNull(funds);
    this.shares = copyOf(checkNotNull(shares));
  }

  public static Portfolio tradingOn(StockMarket stockMarket) {
    return new Portfolio(stockMarket, Money.zero(CurrencyUnit.USD), ImmutableList.<CompanyShares>of());
  }

  public Money funds() {
    return funds;
  }

  public List<CompanyShares> shares() {
    return shares;
  }

  public Portfolio afterBuying(List<CompanyShares> shares) {
    return new Portfolio(stockMarket, funds.minus(stockMarket.priceOf(shares.get(0))), shares);
  }
}
