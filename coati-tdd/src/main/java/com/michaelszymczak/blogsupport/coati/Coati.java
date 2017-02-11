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
    new Coati();
  }

  public Portfolio portfolio() {
    return new Portfolio(ImmutableList.of(CompanyShares.of("GOOGL", 10)));
  }
}
