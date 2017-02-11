package com.michaelszymczak.blogsupport.episode01;

public class Funds extends Value {

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

  public Funds withAdded(Funds fundsToAdd) {
    return Funds.ofValue(value + fundsToAdd.value);
  }

  public Funds withSubtracted(Funds fundToSubtract) {
    return Funds.ofValue(value - fundToSubtract.value);
  }
}
