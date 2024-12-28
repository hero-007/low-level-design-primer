package questions.ticTacToe;

public class Board {
  private Entry[][] gameBoard;

  public Board() {
    this.gameBoard = new Entry[3][3];
  }

  public void play(Entry entry, Position position) {
    validate(position);

    gameBoard[position.row][position.col] = entry;
  }

  public void clear() {
    gameBoard = new Entry[3][3];
  }

  public boolean hasWon(Entry entry) {
    // scan all rows, cols and both diagonals
    for(int i=0; i<=2; i++) {
      boolean won = true;
      for(int j=0; j<=2; j++) {
        if (gameBoard[i][j] != entry)
          won = false;
      }

      if (won)
        return true;

      won = true;
      for(int k=0; k<=2; k++) {
        if (gameBoard[k][i] != entry)
          won = false;
      }

      if (won)
        return true;
    }

    boolean won = true;
    for(int i=0; i<=2; i++) {
      if (gameBoard[i][i] != entry)
        won = false;
    }

    if (won)
      return true;

    won = true;
    for (int i=2,j=0; i>=0; i--,j++){
      if (gameBoard[i][j] != entry)
        won = false;
    }

    if (won)
      return true;

    return false;
  }

  private void validate(Position position) {
    if (gameBoard[position.row][position.col] != null)
      throw new IllegalArgumentException("("+position.row+","+position.col+") is already filled");
  }
}
