package questions.ticTacToe;

public class TicTacToeDemo {

  public static void main(String[] args) {
    Player firstPlayer = new Player("Akhil");
    Player secondPlayer = new Player("Vaibhav");

    Game game = new Game(firstPlayer, secondPlayer);

    game.play(firstPlayer, new Position(0,0));
    game.play(secondPlayer, new Position(1,1));

    game.play(firstPlayer, new Position(0,1));
    game.play(secondPlayer, new Position(1,2));

    game.play(firstPlayer, new Position(0,2));

    game.restart();
  }
}
