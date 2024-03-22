package test;
import main.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChessTester {
  Board twoByTwo = new Board(2);

  @Test
  public void twoByTwoShouldNotAllowFive(){
    Piece whiteKing = new Piece(0,0, false, ChessPieceType.KING);
    Piece blackKing = new Piece(1,1, true, ChessPieceType.KING);
    Piece whiteQueen = new Piece(0,1, false, ChessPieceType.QUEEN);
    Piece blackQueen = new Piece(1,0, true, ChessPieceType.QUEEN);
    twoByTwo.move(whiteKing, whiteKing.x,whiteKing.y);
    twoByTwo.move(blackKing, blackKing.x, blackKing.y);
    twoByTwo.move(whiteQueen, whiteQueen.x, whiteQueen.y);
    twoByTwo.move(blackQueen, blackQueen.x, blackQueen.y);
    Piece whitePawn = new Piece(0,0,false, ChessPieceType.PAWN);
    assertThrows(IllegalArgumentException.class, () -> {
      twoByTwo.move(whitePawn, whitePawn.x,whitePawn.y);
    });
  }

  @Test
  public void twoByTwoShouldNotAllowEating(){
    Piece whiteKing = new Piece(0,0, false, ChessPieceType.KING);
    Piece blackKing = new Piece(1,1, true, ChessPieceType.KING);
    Piece whiteQueen = new Piece(0,1, false, ChessPieceType.QUEEN);
    Piece blackQueen = new Piece(1,0, true, ChessPieceType.QUEEN);
    twoByTwo.move(whiteKing, whiteKing.x,whiteKing.y);
    twoByTwo.move(blackKing, blackKing.x, blackKing.y);
    twoByTwo.move(whiteQueen, whiteQueen.x, whiteQueen.y);
    twoByTwo.move(blackQueen, blackQueen.x, blackQueen.y);
    assertThrows(IllegalArgumentException.class, () -> {
      twoByTwo.move(whiteKing, blackKing.x, blackKing.y);
    });
  }
}
