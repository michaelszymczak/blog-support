package com.michaelszymczak.blogsupport.coati;

import com.michaelszymczak.blogsupport.coati.support.Value;
import org.joda.money.Money;

import static com.google.common.base.Preconditions.checkNotNull;

public class Portfolio extends Value {

  private final Assets assets;
  private final Money funds;

  public static Portfolio with(Assets assets, Money funds) {
    return new Portfolio(assets, funds);
  }

  public Portfolio(Assets assets, Money funds) {
    this.assets = checkNotNull(assets);
    this.funds = checkNotNull(funds);
  }
}
