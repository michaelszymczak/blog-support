package com.michaelszymczak.diamond

import com.michaelszymczak.diamond.api.Letter
import com.michaelszymczak.diamond.app.DiamondFactory
import spock.lang.Specification

class DiamondAcceptanceTest extends Specification {

  def "contains one letter if it is the first letter"() {
    expect:
    new DiamondFactory().createFor(Letter.A).rendered() == "A"
  }

  def "uses all letters up to the provided one"() {
    expect:
    new DiamondFactory().createFor(Letter.B).rendered() == "" +
            " A " + "\n" +
            "B B" + "\n" +
            " A "
  }

  def "creates diamond-like shape"() {
    expect:
    new DiamondFactory().createFor(Letter.C).rendered() == "" +
            "  A  " + "\n" +
            " B B " + "\n" +
            "C   C" + "\n" +
            " B B " + "\n" +
            "  A  "
  }

  def "uses all letters if possible"() {
    expect:
    new DiamondFactory().createFor(Letter.Z).rendered() == "" +
            "                         A                         " + "\n" +
            "                        B B                        " + "\n" +
            "                       C   C                       " + "\n" +
            "                      D     D                      " + "\n" +
            "                     E       E                     " + "\n" +
            "                    F         F                    " + "\n" +
            "                   G           G                   " + "\n" +
            "                  H             H                  " + "\n" +
            "                 I               I                 " + "\n" +
            "                J                 J                " + "\n" +
            "               K                   K               " + "\n" +
            "              L                     L              " + "\n" +
            "             M                       M             " + "\n" +
            "            N                         N            " + "\n" +
            "           O                           O           " + "\n" +
            "          P                             P          " + "\n" +
            "         Q                               Q         " + "\n" +
            "        R                                 R        " + "\n" +
            "       S                                   S       " + "\n" +
            "      T                                     T      " + "\n" +
            "     U                                       U     " + "\n" +
            "    V                                         V    " + "\n" +
            "   W                                           W   " + "\n" +
            "  X                                             X  " + "\n" +
            " Y                                               Y " + "\n" +
            "Z                                                 Z" + "\n" +
            " Y                                               Y " + "\n" +
            "  X                                             X  " + "\n" +
            "   W                                           W   " + "\n" +
            "    V                                         V    " + "\n" +
            "     U                                       U     " + "\n" +
            "      T                                     T      " + "\n" +
            "       S                                   S       " + "\n" +
            "        R                                 R        " + "\n" +
            "         Q                               Q         " + "\n" +
            "          P                             P          " + "\n" +
            "           O                           O           " + "\n" +
            "            N                         N            " + "\n" +
            "             M                       M             " + "\n" +
            "              L                     L              " + "\n" +
            "               K                   K               " + "\n" +
            "                J                 J                " + "\n" +
            "                 I               I                 " + "\n" +
            "                  H             H                  " + "\n" +
            "                   G           G                   " + "\n" +
            "                    F         F                    " + "\n" +
            "                     E       E                     " + "\n" +
            "                      D     D                      " + "\n" +
            "                       C   C                       " + "\n" +
            "                        B B                        " + "\n" +
            "                         A                         "
  }
}