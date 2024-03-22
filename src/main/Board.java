package main;

import java.util.NoSuchElementException;

public class Board {
  Piece[][] pieces;
  private final int dimensions;
  public Board(int size) {
    this.pieces = new Piece[size][size];
    this.dimensions = size;
  }

  public boolean hasPiece(int x, int y) {
    if (x > dimensions || y > dimensions){throw new NoSuchElementException();}
    return pieces[x][y] != null;
  }

  public void move(Piece piece, int toX, int toY) {
    if(hasPiece(toX, toY)){throw new IllegalArgumentException();}
    pieces[piece.x][piece.y] = null;
    pieces[toX][toY] = piece;
    piece.move(toX, toY);
  }

}
