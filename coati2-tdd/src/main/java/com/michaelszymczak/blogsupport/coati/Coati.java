package com.michaelszymczak.blogsupport.coati;

import static com.google.common.collect.ImmutableList.of;

public class Coati {

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

  public Portfolio portfolioOf(User user) {
    return Portfolio.with(Assets.with(of(CompanyShares.of(new Ticker("GOOG"), 10))));
  }
}
