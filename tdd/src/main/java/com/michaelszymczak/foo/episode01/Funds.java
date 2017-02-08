package com.michaelszymczak.foo.episode01;

public class Funds {

  private final int value;

  private Funds(int value)
  {
    this.value = value;
  }

  public static Funds ofValue(int value) {
    return new Funds(value);
  }


  public boolean available() {
    return value != 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Funds funds = (Funds) o;

    return value == funds.value;

  }

  @Override
  public int hashCode() {
    return value;
  }

  public Funds withAdded(Funds fundsToAdd) {
    return Funds.ofValue(value + fundsToAdd.value);
  }

  public Funds withSubtracted(Funds fundToSubtract) {
    return Funds.ofValue(value - fundToSubtract.value);
  }
}
