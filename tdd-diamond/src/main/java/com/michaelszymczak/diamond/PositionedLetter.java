package com.michaelszymczak.diamond;

public class PositionedLetter extends ValueObject {
  private final Coordinates coordinates;
  private final Letter letter;

  public PositionedLetter(Coordinates coordinates, Letter letter) {
    this.coordinates = coordinates;
    this.letter = letter;
  }

  public int maxXorY() {
    return coordinates.maxXorY();
  }

  public String letterAsString() {
    return letter.toString();
  }

  public int getX() {
    return coordinates.getX();
  }

  public int getY() {
    return coordinates.getY();
  }
}
