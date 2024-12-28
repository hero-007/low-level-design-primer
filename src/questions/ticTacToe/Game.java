package questions.ticTacToe;

public class Game {
  private Board board;
  private Player firstPlayer;
  private Player secondPlayer;

  private boolean isFirstPlayerTurn;
  private boolean isGameFinished;


  Game(Player firstPlayer, Player secondPlayer) {
    board = new Board();
    this.firstPlayer = firstPlayer;
    this.secondPlayer = secondPlayer;


    isFirstPlayerTurn = true;
    isGameFinished = false;
  }

  public void play(Player player, Position position) {
    validate(player);
    Entry entry = getEntry(player);

    board.play(entry, position);

    if (board.hasWon(entry)) {
      isGameFinished = true;
      System.out.println("Congratulations! "+ player.getUsername()+" has won the game");
    }

    isFirstPlayerTurn = !isFirstPlayerTurn;
  }

  public void restart() {
    board.clear();
    isGameFinished = false;
    isFirstPlayerTurn = true;
  }

  private void validate(Player player) {
    if (isGameFinished)
      throw new IllegalArgumentException("This game is finished, restart the game to play a new one.");

    if (player == firstPlayer && !isFirstPlayerTurn)
      throw new IllegalArgumentException("This is second player's turn");

    if (player == secondPlayer && isFirstPlayerTurn)
      throw new IllegalArgumentException("This is first player's turn");
  }

  private Entry getEntry(Player player) {
    if (player == firstPlayer)
      return Entry.ZERO;
    else if (player == secondPlayer)
      return Entry.CROSS;
    else throw new IllegalArgumentException("Invalid player, this player is not part of this game.");
  }

}
