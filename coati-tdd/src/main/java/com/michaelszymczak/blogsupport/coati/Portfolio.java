package com.michaelszymczak.blogsupport.coati;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.michaelszymczak.blogsupport.coati.Assets.noAssets;

public class Portfolio extends Value {

  private final StockMarket stockMarket;
  private final Money funds;
  private final Assets assets;

  Portfolio with(Money funds, List<CompanyShares> shares)
  {
    return new Portfolio(stockMarket, funds, Assets.of(shares));
  }

  private Portfolio(StockMarket stockMarket, Money funds, Assets assets) {
    this.stockMarket = checkNotNull(stockMarket);
    this.funds = checkNotNull(funds);
    this.assets = checkNotNull(assets);
  }

  public static Portfolio tradingOn(StockMarket stockMarket) {
    return new Portfolio(stockMarket, noFunds(), noAssets());
  }

  public Portfolio afterBuying(List<CompanyShares> shares) {
    return new Portfolio(
            stockMarket,
            funds.minus(stockMarket.priceOf(shares)),
            assets.withAdditional(shares)
    );
  }

  private static Money noFunds() {
    return Money.zero(CurrencyUnit.USD);
  }
}
