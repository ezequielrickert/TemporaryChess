package test;
import main.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.InvalidObjectException;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChessTester {
  Board twoByTwo = new Board(2);

  @Test
  public void twoByTwoShouldNotAllowFive(){
    Piece whiteKing = new Piece(false, ChessPieceType.KING);
    Piece blackKing = new Piece(true, ChessPieceType.KING);
    Piece whiteQueen = new Piece(false, ChessPieceType.QUEEN);
    Piece blackQueen = new Piece( true, ChessPieceType.QUEEN);
    Board onePiece = twoByTwo.setPiece(whiteKing, 0,0 );
    Board twoPieces = onePiece.setPiece(blackKing, 1, 1);
    Board threePieces  = twoPieces.setPiece(whiteQueen, 0, 1);
    Board fourPieces = threePieces.setPiece(blackQueen, 1, 0);
    Piece whitePawn = new Piece(false, ChessPieceType.PAWN);
    assertThrows(IllegalArgumentException.class, () -> {
      fourPieces.setPiece(whitePawn, 0,0);
    });
  }

  @Test
  public void oneAndTwoShouldBeDifferentBoards() {
    Piece whiteKing = new Piece(false, ChessPieceType.KING);
    Piece blackKing = new Piece(true, ChessPieceType.KING);
    Board onePiece = twoByTwo.setPiece(whiteKing, 0, 0);
    Board twoPieces = onePiece.setPiece(blackKing, 1, 1);
    Assertions.assertNotEquals(onePiece, twoPieces);
  }

  @Test
  public void shouldCheckMatchingPiece(){
    Piece whiteKing = new Piece(false, ChessPieceType.KING);
    Piece blackKing = new Piece(true, ChessPieceType.KING);
    Piece whiteQueen = new Piece(false, ChessPieceType.QUEEN);
    Piece blackQueen = new Piece( true, ChessPieceType.QUEEN);
    Board onePiece = twoByTwo.setPiece(whiteKing, 0,0 );
    Board twoPieces = onePiece.setPiece(blackKing, 1, 1);
    Board threePieces  = twoPieces.setPiece(whiteQueen, 0, 1);
    Board fourPieces = threePieces.setPiece(blackQueen, 1, 0);
    assertThrows(InvalidObjectException.class, () -> {
      fourPieces.move(whiteQueen, 0,0, 0, 1);
    });
  }

  @Test
  public void shouldCheckValidSquare(){
    Piece whiteKing = new Piece(false, ChessPieceType.KING);
    Piece blackKing = new Piece(true, ChessPieceType.KING);
    Piece whiteQueen = new Piece(false, ChessPieceType.QUEEN);
    Piece blackQueen = new Piece( true, ChessPieceType.QUEEN);
    Board onePiece = twoByTwo.setPiece(whiteKing, 0,0 );
    Board twoPieces = onePiece.setPiece(blackKing, 1, 1);
    Board threePieces  = twoPieces.setPiece(whiteQueen, 0, 1);
    assertThrows(InvalidObjectException.class, () -> {
      threePieces.move(blackQueen, 1,0, 0, 1);
    });
  }

  @Test
  public void twoByTwoShouldNotAllowEating(){
    Piece whiteKing = new Piece(false, ChessPieceType.KING);
    Piece blackKing = new Piece(true, ChessPieceType.KING);
    Piece whiteQueen = new Piece(false, ChessPieceType.QUEEN);
    Piece blackQueen = new Piece( true, ChessPieceType.QUEEN);
    Board onePiece = twoByTwo.setPiece(whiteKing, 0,0 );
    Board twoPieces = onePiece.setPiece(blackKing, 1, 1);
    Board threePieces  = twoPieces.setPiece(whiteQueen, 0, 1);
    Board fourPieces = threePieces.setPiece(blackQueen, 1, 0);
    assertThrows(IllegalArgumentException.class, () -> {
      fourPieces.move(whiteKing, 0,0, 0, 1);
    });
  }

  @Test
  public void shouldAllowMoving() throws InvalidObjectException {
    Piece whiteKing = new Piece(false, ChessPieceType.KING);
    Piece blackKing = new Piece(true, ChessPieceType.KING);
    Board onePiece = twoByTwo.setPiece(whiteKing, 0, 0);
    Board twoPieces = onePiece.setPiece(blackKing, 0, 1);
    Board moveWhite = twoPieces.move(whiteKing,  0,0,1,1);
    Assertions.assertTrue(moveWhite.hasPiece(1,1));
    Assertions.assertFalse(moveWhite.hasPiece(0,0));
    Assertions.assertFalse(twoPieces.hasPiece(1,1));
    Assertions.assertTrue(twoPieces.hasPiece(0,0));
  }
}
