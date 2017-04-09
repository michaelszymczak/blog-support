package com.michaelszymczak.diamond;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Board {

  private final PositionedLetter[][] board;
  private final String emptyCell;

  public Board(PositionedLetter... cells) {
    this(" ", asList(cells));
  }

  public Board(Collection<PositionedLetter> cells) {
    this(" ", cells);
  }

  public Board(String emptyCell, Collection<PositionedLetter> cells) {
    this.emptyCell = emptyCell;
    this.board = boardWith(cells);
  }


  private static PositionedLetter[][] boardWith(Collection<PositionedLetter> cells) {
    int maxCellPosition = cells.stream()
            .mapToInt(PositionedLetter::maxXorY)
            .max()
            .orElse(0);
    PositionedLetter[][] board = new PositionedLetter[maxCellPosition+1][maxCellPosition+1];
    cells.forEach(cell -> board[cell.getY()][cell.getX()] = cell);

    return board;
  }

  @Override
  public String toString() {
    return Arrays.stream(board)
            .map(this::rendered)
            .collect(Collectors.joining("\n"));
  }

  private String rendered(PositionedLetter[] row) {
    return Arrays.stream(row)
            .map(cell -> (cell != null) ? cell.letterAsString() : emptyCell)
            .collect(Collectors.joining());
  }

}
