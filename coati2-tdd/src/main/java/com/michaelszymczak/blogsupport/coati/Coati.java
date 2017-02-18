package com.michaelszymczak.blogsupport.coati;

import com.google.common.collect.ImmutableList;

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
    return Portfolio.with(ImmutableList.of(CompanyShares.of(new Ticker("GOOG"), 10)));
  }
}
