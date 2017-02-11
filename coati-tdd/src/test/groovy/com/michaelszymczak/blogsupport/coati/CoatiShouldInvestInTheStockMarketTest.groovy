package com.michaelszymczak.blogsupport.coati

import spock.lang.Specification

class CoatiShouldInvestInTheStockMarketTest extends Specification
{
  def "buy some shares having enough funds"() {
    given:
    'stock market listing' 'GOOG sold USD 813.67 per share'
    'available funds' 'USD 100000'
    'no shares'

    when:
    'bought' '10 of GOOG'

    then:
    'available funds should be' 'USD 91863.30'
    'should have' '10 shares of GOOG'
  }

  private static void "available funds"(String s) {
    
  }

  private static void "stock market listing"(String s) {

  }

  private static void "bought"(String s) {

  }


  private static void "should have"(String s) {
    assert true
  }

  private static void "available funds should be"(String s) {
    assert true
  }
}
