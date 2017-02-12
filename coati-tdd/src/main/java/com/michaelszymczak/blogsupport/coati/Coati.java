package com.michaelszymczak.blogsupport.coati;

import com.google.common.collect.ImmutableList;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.List;

import static org.joda.money.Money.parse;

public class Coati {

  private final String name;
  private Portfolio portfolio;

  public static Coati createForNewPlayer(String name, StockMarket stockMarket, Money initialFunds, List<CompanyShares> initialShares)
  {
    return new Coati(name, stockMarket, initialFunds, initialShares);
  }

  private Coati(String name, StockMarket stockMarket, Money funds, List<CompanyShares> shares) {
    this.name = name;
    // TODO: at some point remove hardcoded values
    this.portfolio = Portfolio.tradingOn(stockMarket).with(parse("USD 91873.30"), ImmutableList.of(CompanyShares.of("GOOG", 10)));
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

    Coati coati = new Coati(
            "some player",
            StockMarket.listing(ImmutableList.<ListedCompany>of()),
            Money.zero(CurrencyUnit.USD),
            ImmutableList.<CompanyShares>of());

    System.out.println("Player: " + coati.name());
    System.out.println("Funds:  " + coati.funds());
    System.out.println("Shares: " + coati.shares());
  }

  public String name() {
    return name;
  }

  public Money funds() {
    return portfolio.funds();
  }

  public List<CompanyShares> shares()
  {
    return portfolio.shares();
  }

  public synchronized void bought(String player, List<CompanyShares> shares) {
    portfolio = portfolio.afterBuying(shares);
  }
}
