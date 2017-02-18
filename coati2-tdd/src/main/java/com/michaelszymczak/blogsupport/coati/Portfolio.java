package com.michaelszymczak.blogsupport.coati;

import com.michaelszymczak.blogsupport.coati.support.Value;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class Portfolio extends Value {

  private final Assets assets;

  @Deprecated
  public static Portfolio with(List<CompanyShares> shares) {
    return Portfolio.with(Assets.with(shares));
  }

  public static Portfolio with(Assets assets) {
    return new Portfolio(assets);
  }

  public Portfolio(Assets assets) {
    this.assets = checkNotNull(assets);
  }
}
