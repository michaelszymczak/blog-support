package com.michaelszymczak.diamond.implementation

import spock.lang.Specification

import static com.michaelszymczak.diamond.api.Letter.*
import static com.michaelszymczak.diamond.implementation.Coordinates.ofYX

class BoardShould extends Specification {

  def "should print a symbol"() {
    expect: new Board([new PositionedLetter(ofYX(0,0),B)]).toString() == "B"
  }

  def "should print symbols respecting their positions"() {
    expect:
    new Board([
            new PositionedLetter(ofYX(0,0),A),
            new PositionedLetter(ofYX(0,1),B),
            new PositionedLetter(ofYX(1,0),C),
            new PositionedLetter(ofYX(1,1),D),
    ]).toString() == shapeOf("""
AB
CD
""")
  }

  def "should fill gaps with defined symbol "() {
    expect:
    new Board("_", [
            new PositionedLetter(ofYX(0,2),A),
            new PositionedLetter(ofYX(1,1),B),
            new PositionedLetter(ofYX(1,3),B),
            new PositionedLetter(ofYX(2,0),C),
            new PositionedLetter(ofYX(2,4),C),
            new PositionedLetter(ofYX(3,1),B),
            new PositionedLetter(ofYX(3,3),B),
            new PositionedLetter(ofYX(4,2),A),
    ]).toString() == shapeOf("""
__A__
_B_B_
C___C
_B_B_
__A__
""")
  }

  private static String shapeOf(String shape) {
    shape.replaceAll("^\n", "").replaceAll("\n\$", "")
  }
}
