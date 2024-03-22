
package main;
public class Piece {
  public boolean color;
  public int x;
  public int y;
  public ChessPieceType type;

  public Piece(int x, int y, boolean color, ChessPieceType type) {
    this.color = color;
    this.x = x;
    this.y = y;
    this.type = type;
  }

  void move(int toX, int toY) {
    x = toX;
    y = toY;
  }
}