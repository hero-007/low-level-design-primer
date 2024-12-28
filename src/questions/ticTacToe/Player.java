package questions.ticTacToe;

public class Player {
  private Integer id;
  private String username;

  public Player(String username) {
    this.id = Utils.generateId();
    this.username = username;
  }

  public String getUsername() {
    return username;
  }
}
