package com.michaelszymczak.blogsupport.coati;

import org.joda.money.Money;

import static com.google.common.collect.ImmutableList.of;

public class Coati {

  private Portfolio onlyUserPortfolio = null;

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
  }

  public synchronized Portfolio portfolioOf(User user) {
    return onlyUserPortfolio;
  }

  public synchronized void buyFor(User user, Assets newAssets) {
    onlyUserPortfolio = Portfolio.with(Assets.with(of(CompanyShares.of(new Ticker("GOOG"), 10))), Money.parse("USD 91863.30"));
  }

  public synchronized void addPortfolioFor(User user, Portfolio portfolio) {

  }
}
