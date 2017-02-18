package com.michaelszymczak.blogsupport.coati;

import com.michaelszymczak.blogsupport.coati.support.Value;

import static com.google.common.base.Preconditions.checkNotNull;

public class Portfolio extends Value {

  private final Assets assets;

  public static Portfolio with(Assets assets) {
    return new Portfolio(assets);
  }

  public Portfolio(Assets assets) {
    this.assets = checkNotNull(assets);
  }
}
