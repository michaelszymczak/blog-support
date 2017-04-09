package com.michaelszymczak.diamond;

public class Coordinates extends ValueObject {

  private final int y;
  private final int x;

  public static Coordinates ofYX(int y, int x)
  {
    return new Coordinates(y, x);
  }

  private Coordinates(int y, int x) {
    this.y = y;
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public int getX() {
    return x;
  }

  public int maxXorY() {
    return x > y ? x : y;
  }
}
