package com.michaelszymczak.blogsupport.coati;

import com.google.common.collect.ImmutableList;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.List;

public class Coati {

  public Coati(StockMarket stockMarket, Money funds, List<CompanyShares> shares) {
  }

  public static void main(String[] args) {
    System.out.println("                                      ");
    System.out.println("                              .::     ");
    System.out.println("                              .::     ");
    System.out.println("    .:::   .::       .::    .:.: .:  /");
    System.out.println("  .::    .::  .::  .::  .::   .::   //");
    System.out.println(" .::    .::    .::.::   .::   .::  // ");
    System.out.println("  .::    .::  .:: .::   .::   .::     ");
    System.out.println("    .:::   .::      .:: .:::   .::()  ");
    System.out.println("                                      ");
    new Coati(
            new StockMarket(ImmutableList.<ListedCompany>of()),
            Money.zero(CurrencyUnit.USD),
            ImmutableList.<CompanyShares>of());
  }

  public Portfolio portfolio() {
    // TODO
    return new Portfolio(ImmutableList.of(CompanyShares.of("GOOG", 10)));
  }

  public Money funds() {
    // TODO
    return Money.parse("USD 91863.30");
  }

  public Coati bought(List<CompanyShares> shares) {
    return this;
  }
}
