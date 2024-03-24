package main;

import java.io.InvalidObjectException;
import java.util.NoSuchElementException;

public class Board {
  private final Piece[][] pieces;
  private final int dimensions;
  public Board(int size) {
    this.pieces = new Piece[size][size];
    this.dimensions = size;
  }

  private Board(int size, Piece[][] board) {
    this.dimensions = size;
    this.pieces = new Piece[size][size];
    for (int i = 0; i < size; i++) {
      this.pieces[i] = board[i].clone();
    }  }

  private void checkSquare(int x, int y) {
    if (x >= dimensions || y >= dimensions){throw new NoSuchElementException();}
  }

  private boolean isSamePiece(Piece checkPiece, int x, int y) {
    if(hasPiece(x,y)){
      Piece boardPiece = pieces[x][y];
      return boardPiece.equals(checkPiece);
    }
    return false;
  }

  public boolean hasPiece(int x, int y) {
    checkSquare(x, y);
    return pieces[x][y] != null;
  }

  public Board setPiece(Piece piece, int x, int y) {
    if(hasPiece(x, y)){throw new IllegalArgumentException();}
    Board outBoard = new Board(this.dimensions, this.pieces);
    outBoard.pieces[x][y] = piece;
    return outBoard;
  }

  public Board move(Piece piece, int fromX, int fromY, int toX, int toY) throws InvalidObjectException {
    if(isSamePiece(piece, fromX, fromY)){
      if(hasPiece(toX, toY)){throw new IllegalArgumentException();}
      Board outBoard = new Board(this.dimensions, this.pieces);
      outBoard.pieces[fromX][fromY] = null;
      outBoard.pieces[toX][toY] = piece;
      return outBoard;
    }
    else throw new InvalidObjectException("Not the same piece or empty field!");
  }

}
