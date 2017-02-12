package com.michaelszymczak.blogsupport.coati;

import com.google.common.collect.ImmutableList;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.List;

import static com.michaelszymczak.blogsupport.coati.Portfolio.tradingOn;

public class Coati {

  private final String name;
  private Portfolio portfolio;

  public static Coati createForNewPlayer(String name, StockMarket stockMarket, Money initialFunds, List<CompanyShares> initialShares)
  {
    return new Coati(name, stockMarket, initialFunds, initialShares);
  }

  private Coati(String name, StockMarket stockMarket, Money funds, List<CompanyShares> shares) {
    this.name = name;
    this.portfolio = tradingOn(stockMarket).with(funds, shares);
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
            "some player",
            StockMarket.listing(ImmutableList.<ListedCompany>of()),
            Money.zero(CurrencyUnit.USD),
            ImmutableList.<CompanyShares>of());
  }

  public synchronized void bought(String player, List<CompanyShares> shares) {
    portfolio = portfolio.afterBuying(shares);
  }

  public Portfolio portfolio(String player)
  {
    return portfolio;
  }
}
