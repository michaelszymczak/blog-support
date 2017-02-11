package com.michaelszymczak.blogsupport.coati;

import com.google.common.collect.ImmutableList;
import org.joda.money.Money;

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
    // TODO
    return new Portfolio(ImmutableList.of(CompanyShares.of("GOOGL", 10)));
  }

  public Money funds() {
    // TODO
    return Money.parse("USD 91863.30");
  }
}
